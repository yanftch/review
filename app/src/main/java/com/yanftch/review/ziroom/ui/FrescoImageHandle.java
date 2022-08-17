package com.yanftch.review.ziroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @inheritDoc
 * */
public class FrescoImageHandle implements IImageHandler {

    private static final ScalingUtils.ScaleType DEFAUT_SCYLE_TYPE = ScalingUtils.ScaleType.FIT_XY;
    private static final int DEFAULT_DURATION = 500;//动画淡出时长ms

    private Context mContext;
    private AbstractDraweeControllerBuilder mControllerBuilder;
    private GenericDraweeHierarchyBuilder mDraweeHierarchyBuilder;
    private ImageRequestBuilder mImageRequestBuilder;
    private Postprocessor mProcessor;
    private RoundingParams mParams;
    private ResizeOptions mOptions;
    private RotationOptions mRotationOps;
    private boolean mProgressiveEnabled = false;
    private float mRatio = 0.0f;
    private EncodeImageInfo mImageInfo;
    private volatile boolean mInitialed = false;
    private boolean mNeedChangeFade = false;

    /**
    * 是否是直接代码编写的PictureView，对于这种情况是没有Hierarchy的
    */
    private boolean mIsCodeHierarchy = false;

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int MAX_POOL_COUNT = CPU_COUNT * 2;
    private static final int CORE_POOL_SIZE = CPU_COUNT;
    private static final int KEEP_ALIVE = 120;

    private static ThreadFactory mThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"fresco_download#" + mCount.getAndIncrement());
        }
    };

    public static ExecutorService mDownloadThreadPoolExecuter = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_COUNT, KEEP_ALIVE, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), mThreadFactory);

    public FrescoImageHandle(@NonNull Context context)
    {
        super();
        this.mContext = context;
        initData();
    }

    private void initData()
    {
        mControllerBuilder = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true);
        mDraweeHierarchyBuilder = GenericDraweeHierarchyBuilder.newInstance(mContext.getResources());
    }
    /*
     * @params uri 图片所对应的地址
     * 远程图片	http://, https://	HttpURLConnection 或者参考 使用其他网络加载方案
     * 本地文件	    file://	            FileInputStream
     * Content provider	content://	ContentResolver
     * asset目录下的资源	asset://	AssetManager
     * res目录下的资源	res://	Resources.openRawResource
     * Uri中指定图片数据	data:mime/type;base64,	数据类型必须符合 rfc2397规定 (仅支持 UTF-8)
     * */
    @Override
    public FrescoImageHandle setImageUri(@NonNull String uri) {

        if(uri == null)
        {
            return this;
        }
        mImageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(uri));
        return this;
    }

    /*
     * @params resId res目录下图片所对应的id值，这里不支持xml，颜色，及字符串
     * 只支持图片类型，如png
     * 对于mipmap目前也是不支持的
     * */
    @Override
    public FrescoImageHandle setImageUri(int resId) {
        mImageRequestBuilder = ImageRequestBuilder.newBuilderWithResourceId(resId);
        return this;
    }

    @Override
    public IImageHandler setLocalImageUri(String filepath) {
        if(filepath != null && filepath.contains("file://"))
            mImageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(filepath));
        else
            mImageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(filepath)));
        return this;
    }

    @Override
    public IImageHandler setImageUri(Uri uri) {
        if(uri == null)
        {
            return this;
        }
        mImageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(uri);
        return this;
    }

    @Override
    public FrescoImageHandle setActualImageScaleType(int scaleType)
    {
        mDraweeHierarchyBuilder.setActualImageScaleType(convertScaleType(scaleType));
        return this;
    }

    @Override
    public IImageHandler setFadeDuration(int fadeDuration) {
        mNeedChangeFade = true;
        mDraweeHierarchyBuilder.setFadeDuration(fadeDuration);
        return this;
    }


    @Override
    public FrescoImageHandle setPlaceHolderImage(int resId)
    {
        mDraweeHierarchyBuilder.setPlaceholderImage(resId);
        return this;
    }

    @Override
    public FrescoImageHandle setPlaceHolderImage(Drawable drawable) {
        mDraweeHierarchyBuilder.setPlaceholderImage(drawable);
        return this;
    }

    @Override
    public FrescoImageHandle setPlaceHolderImage(int resId, int scaleType) {
        mDraweeHierarchyBuilder.setPlaceholderImage(resId, convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setPlaceHolderImage(Drawable drawable, int scaleType) {
        mDraweeHierarchyBuilder.setPlaceholderImage(drawable, convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setPlaceHolderImageScaleType(int scaleType) {
        mDraweeHierarchyBuilder.setFailureImage(null, convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setDesiredAspectRatio(float ratio) {
        mRatio = ratio;
        mDraweeHierarchyBuilder.setDesiredAspectRatio(ratio);
        return this;
    }

    @Override
    public FrescoImageHandle setFailureImage(int resId) {
        mDraweeHierarchyBuilder.setFailureImage(resId);
        return this;
    }

    @Override
    public FrescoImageHandle setFailureImage(Drawable drawable) {
        mDraweeHierarchyBuilder.setFailureImage(drawable);
        return this;
    }

    @Override
    public FrescoImageHandle setFailureImage(int resId, int scaleType) {
        mDraweeHierarchyBuilder.setFailureImage(resId, convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setFailureImage(Drawable drawable, int scaleType) {
        mDraweeHierarchyBuilder.setFailureImage(drawable, convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setFailureImageScaleType(int scaleType) {
        mDraweeHierarchyBuilder.setFailureImageScaleType(convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setProgressBarImage(int resId) {
        mDraweeHierarchyBuilder.setProgressBarImage(resId);
        return this;
    }

    @Override
    public FrescoImageHandle setProgressBarImage(Drawable drawable) {
        mDraweeHierarchyBuilder.setProgressBarImage(drawable);
        return this;
    }

    @Override
    public FrescoImageHandle setProgressBarImage(int resId, int scaleType) {
        mDraweeHierarchyBuilder.setProgressBarImage(resId, convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setProgressBarImage(Drawable drawable, int scaleType) {
        mDraweeHierarchyBuilder.setProgressBarImage(drawable, convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setProgressBarImageScaleType(int scaleType) {
        mDraweeHierarchyBuilder.setProgressBarImageScaleType(convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setRetryImage(int resId) {
        mDraweeHierarchyBuilder.setRetryImage(resId);
        return this;
    }

    @Override
    public FrescoImageHandle setRetryImage(Drawable drawable) {
        mDraweeHierarchyBuilder.setRetryImage(drawable);
        return this;
    }

    @Override
    public FrescoImageHandle setRetryImage(int resId, int scaleType) {
        mDraweeHierarchyBuilder.setRetryImage(resId, convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setRetryImage(Drawable drawable, int scaleType) {
        mDraweeHierarchyBuilder.setRetryImage(drawable, convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setRetryImageScaleType(int scaleType) {
        mDraweeHierarchyBuilder.setRetryImageScaleType(convertScaleType(scaleType));
        return this;
    }

    @Override
    public FrescoImageHandle setOverlay(Drawable drawable) {
        mDraweeHierarchyBuilder.setOverlay(drawable);
        return this;
    }

    @Override
    public IImageHandler setOverlays(List drawables) {
        mDraweeHierarchyBuilder.setOverlays(drawables);
        return this;
    }

    @Override
    public FrescoImageHandle setPressedStateOverlay(Drawable drawable) {
        mDraweeHierarchyBuilder.setPressedStateOverlay(drawable);
        return this;
    }

    @Override
    public FrescoImageHandle setRoundAsCircle(boolean bool) {
        if(mParams == null)
        {
            mParams = new RoundingParams();
        }

        mParams.setRoundAsCircle(bool);
        return this;
    }

    @Override
    public FrescoImageHandle setCornersRadius(float radius) {
        if(mParams == null)
        {
            mParams = RoundingParams.fromCornersRadius(radius);
        }
        else
        {
            mParams.setCornersRadius(radius);
        }
        return this;
    }

    @Override
    public FrescoImageHandle setCornersRadii(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        if (mParams == null) {
            mParams = RoundingParams.fromCornersRadii(topLeft, topRight, bottomRight, bottomLeft);
        } else {
            mParams.setCornersRadii(topLeft, topRight, bottomRight, bottomLeft);
        }
        return this;
    }

    @Override
    public FrescoImageHandle setBorder(@ColorInt int color, float width) {
        if (mParams == null) {
            mParams = new RoundingParams();
        }
        mParams.setBorder(color, width);
        return this;
    }

    @Override
    public FrescoImageHandle setControllerListener(IImageHandleListener listener) {
        ImageControllerListener imageControllerListener = new ImageControllerListener(listener);
        mControllerBuilder.setControllerListener(imageControllerListener);
        return this;
    }

    @Override
    public FrescoImageHandle setPostProcessor(ImageProcessor processor)
    {
        mProcessor = processor;
        return this;
    }

    @Override
    public FrescoImageHandle setResizeOption(int width, int height)
    {
        mOptions = ResizeOptions.forDimensions(width, height);
        return this;
    }

    @Override
    public FrescoImageHandle setAutoPlayAnimations(boolean enabled) {
        mControllerBuilder.setAutoPlayAnimations(enabled);
        return this;
    }

    /*
     * 当图片加载失败的时候，设置是否允许点击，进行重新下载并加载
     * */
    @Override
    public FrescoImageHandle setTapToRetryEnabled(boolean enabled) {
        mControllerBuilder.setTapToRetryEnabled(true);
        return this;
    }

    /*
     * 该方法用于将我们所做的一些设置添加到view上，来实现控制与展示的结合
     * */
    @Override
    public FrescoImageHandle display(@NonNull PictureView view) {
        return display(view, false);
    }

    @Override
    public FrescoImageHandle display(PictureView view, boolean needOriginSize) {

        if(mDraweeHierarchyBuilder != null)
        {
            if(mRatio != 0)
            {
                view.setAspectRatio(mRatio);
            }

            view.setHierarchy(buildDraweeView(mDraweeHierarchyBuilder, view.getHierarchy()));
        }

        if(mControllerBuilder != null)
        {
            if(mImageRequestBuilder != null)
            {
                mImageRequestBuilder.setProgressiveRenderingEnabled(mProgressiveEnabled);
                if(mOptions != null)
                {
                    mImageRequestBuilder.setResizeOptions(mOptions);
                } else {
                    if(view.getLayoutParams() != null && view.getLayoutParams().width > 0 && view.getLayoutParams().height > 0) { // w 和 h 分别是 360、270
                        mImageRequestBuilder.setResizeOptions(new ResizeOptions(view.getLayoutParams().width, view.getLayoutParams().height));
                    }

                }

                if(mProcessor != null)
                {
                    mImageRequestBuilder.setPostprocessor(mProcessor);
                }

                if(mRotationOps != null)
                {
                    mImageRequestBuilder.setRotationOptions(mRotationOps);
                }

                mControllerBuilder.setImageRequest(mImageRequestBuilder.build());
            }

            mControllerBuilder.setOldController(view.getController());
            view.setController(mControllerBuilder.build());
        }

        if(needOriginSize)
        {
            initOriginImageSize();
        }

        return this;
    }

    @Override
    public IImageHandler setProgressiveRenderingEnabled(boolean enabled) {
        mProgressiveEnabled = enabled;
        return this;
    }

    @Override
    public IImageHandler fetchImage(ImageFetchCallBack callBack) {
        if(mImageRequestBuilder == null)
        {
            return this;
        }
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(mImageRequestBuilder.build(), mContext);
        dataSource.subscribe(callBack, mDownloadThreadPoolExecuter);
        return this;
    }

    private static final String TAG = "debug_FrescoImageHandle";
    private class ImageCallBack extends ImageFetchCallBack
    {
        @Override
        protected void onNewResultImpl(Bitmap bitmap) {
            if (bitmap != null) {
                Log.e(TAG, "onNewResultImpl: bitmap.getHeight() = " + bitmap.getHeight() + ", bitmap.getWidth() = "+ bitmap.getWidth());
            }
            Log.i("xjq", "done");
            mImageInfo = new EncodeImageInfo();
            mImageInfo.height = bitmap.getHeight();
            mImageInfo.width = bitmap.getWidth();
            mInitialed = true;
        }

        @Override
        protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {

        }
    }

    public EncodeImageInfo getOrignalImageInfo()
    {
        if(!mInitialed)
        {
            return null;
        }

        return mImageInfo;
    }

    public void getOrignalImageInfo(ImageFetchCallBack callBack)
    {
        if(mImageRequestBuilder == null)
        {
            return;
        }
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        mImageRequestBuilder.setResizeOptions(null);
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(mImageRequestBuilder.build(), mContext);
        dataSource.subscribe(callBack, mDownloadThreadPoolExecuter);
    }

    /*
     * 请求原始数据，并在callBack中初始化{@code mImageInfo}
     * */
    private void initOriginImageSize()
    {
        if(mImageRequestBuilder == null)
        {
            return;
        }
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        mImageRequestBuilder.setResizeOptions(null);
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(mImageRequestBuilder.build(), mContext);
        dataSource.subscribe(new ImageCallBack(), mDownloadThreadPoolExecuter);
    }

    @Override
    public IImageHandler clear() {
        if(mDraweeHierarchyBuilder != null)
        {
            mDraweeHierarchyBuilder = null;
        }

        if(mControllerBuilder != null)
        {
            mControllerBuilder = null;
        }

        if(mImageRequestBuilder != null)
        {
            mImageRequestBuilder = null;
        }

        if(mProcessor != null)
        {
            mProcessor = null;
        }

        if(mParams != null)
        {
            mParams = null;
        }

        if(mOptions != null)
        {
            mOptions = null;
        }

        return null;
    }

    @Override
    public IImageHandler setAutoRotateEnabled(boolean enabled) {
        if(enabled)
            mRotationOps = RotationOptions.autoRotate();
        else
            mRotationOps = RotationOptions.disableRotation();

        return this;
    }

    @Override
    public FrescoImageHandle setImageBlur(int blurRadius)
    {
        if(blurRadius > 0)
            mProcessor = new IterativeBoxBlurPostProcessor(blurRadius);
        else
            mProcessor = null;
        return this;
    }

    @Override
    public FrescoImageHandle setImageBlur(int iterations, int blurRadius)
    {
        if(blurRadius > 0)
            mProcessor = new IterativeBoxBlurPostProcessor(iterations, blurRadius);
        else
            mProcessor = null;
        return this;
    }

    @Override
    public boolean isHasDiskCache(String url) {
        if(url == null || "".equals(url))
        {
            return false;
        }
        return Fresco.getImagePipelineFactory().getMainFileCache().hasKey(new SimpleCacheKey(url));
    }

    @Override
    public IImageHandler setBackgroundImage(@Nullable Drawable drawable) {
        mDraweeHierarchyBuilder.setBackground(drawable);
        return this;
    }
    /*
     * 由于放大缩小类型属于ScaleType的子类，无法通过直接继承，来把一种子类转化为其它子类
     * 所以这里采用的是做一次转化来得到对应的类型，当然我们也可以通过增加多个类来分别继承这些子类
     * 来达到访问的效果
     * */

    private ScalingUtils.ScaleType convertScaleType(int type)
    {
        ScalingUtils.ScaleType scaleType = DEFAUT_SCYLE_TYPE;
        switch (type)
        {
            case ScaleType.FIT_XY: {
                scaleType = ScalingUtils.ScaleType.FIT_XY;
                break;
            }
            case ScaleType.CENTER:
            {
                scaleType = ScalingUtils.ScaleType.CENTER;
                break;
            }
            case ScaleType.FIT_CENTER:
            {
                scaleType = ScalingUtils.ScaleType.FIT_CENTER;
                break;
            }
            case ScaleType.FIT_END:
            {
                scaleType = ScalingUtils.ScaleType.FIT_END;
                break;
            }
            case ScaleType.FIT_START:
            {
                scaleType = ScalingUtils.ScaleType.FIT_START;
                break;
            }
            case ScaleType.CENTER_INSIDE:
            {
                scaleType = ScalingUtils.ScaleType.CENTER_INSIDE;
                break;
            }
            case ScaleType.CENTER_CROP:
            {
                scaleType = ScalingUtils.ScaleType.CENTER_CROP;
                break;
            }
            case ScaleType.FOCUS_CROP:
            {
                scaleType = ScalingUtils.ScaleType.FOCUS_CROP;
                break;
            }
        }

        return scaleType;
    }

    /*
     * 为了给view添加在布局文件加属性功能，没办法只能通过把builder的内容取出来，然后设置给view已经有Hierarchy
     * 都是自己当初犯的傻，用的不是获取view的Hierarchy的方式，而是新建了一个。
     * Fresco有个问题，如果在代码中新建Hierarchy，那么布局文件中的设置就会失效
     * 如果上天再给你一次机会，你会怎么做呢？
     * */
    private GenericDraweeHierarchy buildDraweeView(GenericDraweeHierarchyBuilder builder, GenericDraweeHierarchy hierarchy)
    {
        if(hierarchy == null )
        {
            if(mParams != null)
            {
                builder.setRoundingParams(mParams);
            }
            return builder.build();
        }

        if(builder.getActualImageScaleType() != GenericDraweeHierarchyBuilder.DEFAULT_ACTUAL_IMAGE_SCALE_TYPE)
        {
            hierarchy.setActualImageScaleType(builder.getActualImageScaleType());
        }

        if(builder.getPlaceholderImage() != null)
        {
            if(builder.getPlaceholderImageScaleType() != GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE)
            {
                hierarchy.setPlaceholderImage(builder.getPlaceholderImage(), builder.getPlaceholderImageScaleType());
            }
            else
            {
                hierarchy.setPlaceholderImage(builder.getPlaceholderImage());
            }
        }

        if(builder.getFailureImage() != null)
        {
            if(builder.getFailureImageScaleType() != GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE)
            {
                hierarchy.setFailureImage(builder.getFailureImage(), builder.getFailureImageScaleType());
            }
            else
            {
                hierarchy.setFailureImage(builder.getFailureImage());
            }
        }

        if(builder.getProgressBarImage() != null)
        {
            if(builder.getProgressBarImageScaleType() != GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE)
            {
                hierarchy.setProgressBarImage(builder.getProgressBarImage(), builder.getProgressBarImageScaleType());
            }
            else
            {
                hierarchy.setPlaceholderImage(builder.getProgressBarImage());
            }
        }

        if(builder.getRetryImage() != null)
        {
            if(builder.getRetryImageScaleType() != GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE)
            {
                hierarchy.setRetryImage(builder.getRetryImage(), builder.getRetryImageScaleType());
            }
            else
            {
                hierarchy.setRetryImage(builder.getRetryImage());
            }
        }
        else if(builder.getRetryImageScaleType() != GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE)
        {

        }

        if(builder.getOverlays() != null)
        {
            List<Drawable> list = builder.getOverlays();
            int size = list.size();
            for(int index = 0; index < size; index++)
            {
                hierarchy.setOverlayImage(index, list.get(index));
            }

            if(builder.getPressedStateOverlay() != null)
            {
                hierarchy.setOverlayImage(size, builder.getPressedStateOverlay());
            }
        }

        if(mNeedChangeFade)
        {
            hierarchy.setFadeDuration(builder.getFadeDuration());
            mNeedChangeFade = false;
        }

        if(mParams != null)
        {
            hierarchy.setRoundingParams(mParams);
        }

        hierarchy.setBackgroundImage(builder.getBackground());

        return hierarchy;
    }

}
