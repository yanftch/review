package com.yanftch.review.ziroom.ui;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import com.facebook.imagepipeline.image.ImageInfo;

import java.util.List;

public interface IImageHandler<Type extends IImageHandler> {
    /**
     * 通过url获取图片
     *
     * @param string 所要加载的图片的url
     */
    public Type setImageUri(String string);

    /**
     * 通过id值来获取res目录下的图片
     * 目前对于xml类型以及mipmap下图片展示有问题
     *
     * @param resId 所要加载的图片的resource对应id
     */
    public Type setImageUri(int resId);

    /**
     * 通过url获取图片
     *
     * @param filepath 所要加载的图片的本地绝对路径
     */
    public Type setLocalImageUri(String filepath);

    /**
     * 通过id值来获取res目录下的图片
     * 目前对于xml类型以及mipmap下图片展示有问题
     *
     * @param uri 所要加载的图片的resource对应uri
     */
    public Type setImageUri(Uri uri);

    /**
     * 设置我们最终展示图片的缩放类型
     *
     * @param scaleType 采用的缩放类型{@link com.ziroom.commonlib.ziroomimage.utils.ScaleType}
     */
    public Type setActualImageScaleType(int scaleType);

    /**
     * @param fadeDuration fade出来所用时长
     */
    public Type setFadeDuration(int fadeDuration);

    /**
     * 获取res目录下图片作为占位图片,这里支持color，xml,mipmap,及图片类型
     *
     * @param resId 占位图所对应的resource id值
     */
    public Type setPlaceHolderImage(int resId);

    /**
     * 将传递过来的drawable作为占位图
     *
     * @param drawable 占位图
     */
    public Type setPlaceHolderImage(Drawable drawable);

    /**
     * @param resId     占位图所对应的id值
     * @param scaleType 占位图采用缩放类型
     */
    public Type setPlaceHolderImage(int resId, int scaleType);

    /**
     * @param drawable  占位图
     * @param scaleType 占位图所采用的缩放类型(#ScaleType)
     */
    public Type setPlaceHolderImage(Drawable drawable, int scaleType);

    /*
     * @param scaleType 占位图所采用的缩放类型
     * */
    public Type setPlaceHolderImageScaleType(int scaleType);


    /**
     * @param ratio 宽高比，宽是高的多少 ratio = widtht/heigh
     *              当前在代码中设定并不能起作用
     */
    public Type setDesiredAspectRatio(float ratio);

    /**
     * @param resId 加载失败，所要显示图片的id值，从res目录找资源
     */
    public Type setFailureImage(int resId);

    /**
     * @param drawable 加载失败所使用的图
     */
    public Type setFailureImage(Drawable drawable);

    /**
     * @param resId     失败图所对应的id值
     * @param scaleType 失败图所采用的缩放类型
     */
    public Type setFailureImage(int resId, int scaleType);

    /**
     * @param drawable  失败图
     * @param scaleType 失败图所采用的缩放类型
     */
    public Type setFailureImage(Drawable drawable, int scaleType);

    /**
     * @param scaleType 失败图所采用的缩放类型
     */
    public Type setFailureImageScaleType(int scaleType);

    /**
     * @param resId 加载过程中所使用进度显示图片的id值
     */
    public Type setProgressBarImage(int resId);

    /**
     * @param drawable 进度条图片
     */
    public Type setProgressBarImage(Drawable drawable);

    /**
     * @param resId     加载过程中所使用进度显示图片的id值
     * @param scaleType 进度条图片所采用的缩放类型
     */
    public Type setProgressBarImage(int resId, int scaleType);

    /**
     * @param drawable  进度条图片
     * @param scaleType 进度条图片所采用的缩放类型
     */
    public Type setProgressBarImage(Drawable drawable, int scaleType);

    /**
     * @param scaleType 进度条图片所采用的缩放类型
     */
    public Type setProgressBarImageScaleType(int scaleType);

    /**
     * @param resId 重试加载所使用的图片id
     */
    public Type setRetryImage(int resId);

    /**
     * @param drawable 重试加载所使用的图片
     */
    public Type setRetryImage(Drawable drawable);

    /**
     * @param resId     重试加载所使用的图片id
     * @param scaleType 重试图片所采用的缩放类型
     */
    public Type setRetryImage(int resId, int scaleType);

    /**
     * @param drawable  重试加载所使用的图片
     * @param scaleType 重试图片所采用的缩放类型
     */
    public Type setRetryImage(Drawable drawable, int scaleType);

    /**
     * @param scaleType 重试图片所采用的缩放类型
     */
    public Type setRetryImageScaleType(int scaleType);

    /**
     * @param drawable 涂层图片，在显示的图片最上一层显示
     */
    public Type setOverlay(Drawable drawable);

    /**
     * @param drawables 要显示的涂层图片集合，按照顺序依次展示在view上
     */
    public Type setOverlays(List<Drawable> drawables);

    /**
     * @param drawable 设置选中状态图片，当按住的时候显示的图片
     */
    public Type setPressedStateOverlay(Drawable drawable);

    /**
     * @param bool 是否将加载图显示为圆形
     */
    public Type setRoundAsCircle(boolean bool);

    /**
     * @param radius 对view加载图四个角进行圆角处理所使用的值
     */
    public Type setCornersRadius(float radius);

    /**
     * 对view加载图四个角进行圆角处理所使用的值
     *
     * @param topLeft
     * @param topRight
     * @param bottomRight
     * @param bottomLeft
     * @return
     */
    Type setCornersRadii(float topLeft, float topRight, float bottomRight, float bottomLeft);

    /**
     * 设置圆角的边框
     *
     * @param color
     * @param width
     * @return
     */
    Type setBorder(@ColorInt int color, float width);

    /**
     * @param listener 图片加载监听器，用于对图片不同的加载过程进行处理
     */
    public Type setControllerListener(IImageHandleListener<ImageInfo> listener);

    /**
     * @param processor 图片后处理器，直接对要加载的图片进行处理
     */
    public Type setPostProcessor(ImageProcessor processor);

    /**
     * 该操作比较耗时，如果要展示的图片比view大的不多或者小的话，建议使用scaleType
     * resize是通过软件处理来实现的，scaleType是由硬件来实现的比较快一些
     *
     * @param width  加载图宽度缩放大小
     * @param height 加载图高度缩放大小
     */
    public Type setResizeOption(int width, int height);

    /**
     * 对于动图，是否设置为自动播放 如gif图
     *
     * @param enabled 是否自动播放动图
     */
    public Type setAutoPlayAnimations(boolean enabled);

    /**
     * 当图片加载失败的时候，设置是否允许点击，进行重新下载并加载
     *
     * @param enabled 是否点击进行重试
     */
    public Type setTapToRetryEnabled(boolean enabled);

    /**
     * 该方法用于将我们所做的一些设置添加到view上，来实现控制与展示的结合
     *
     * @param view 用于展示的view
     */
    public Type display(PictureView view);

    /**
     * 该方法用于将我们所做的一些设置添加到view上，来实现控制与展示的结合
     *
     * @param view           我们所要设定的View
     * @param needOriginSize 是否需要获取原始图片大小
     */
    public Type display(PictureView view, boolean needOriginSize);

    /**
     * @param enabled 是否采用渐变式加载
     */
    public Type setProgressiveRenderingEnabled(boolean enabled);

    /**
     * 该方法用于从网上获取图片，使用此方法前一定要设置获取图片的uri
     *
     * @param callBack 图片获取回调类，在该回调方法中可以得到要处理的图片
     */
    public Type fetchImage(ImageFetchCallBack callBack);

    /**
     * 获取原始图片的大小
     */
    public EncodeImageInfo getOrignalImageInfo();

    /**
     * 获取原始图片的大小
     *
     * @param callBack 获取到原始图片后，回调该类
     */
    public void getOrignalImageInfo(ImageFetchCallBack callBack);

    /**
     * 数据释放
     */
    public Type clear();

    /*
     * whether to rotate by a multiple of 90 degrees, use the
     * EXIF metadata (relevant to JPEGs only) or to not rotate. This also specifies whether the
     * rotation should be left until the bitmap is rendered (as the GPU can do this more efficiently
     * than the effort to change the bitmap object).
     * @param enabled if {@code true} enable auto rotate
     * @since 2018.08.19
     * */
    public Type setAutoRotateEnabled(boolean enabled);

    /**
     * @param blurRadius 模糊图半径，必须大于0，越大越模糊。
     */
    public Type setImageBlur(int blurRadius);

    /**
     * @param iterations 迭代次数，越大越魔化。
     * @param blurRadius 模糊图半径，必须大于0，越大越模糊。
     */
    Type setImageBlur(int iterations, int blurRadius);

    boolean isHasDiskCache(String url);

    Type setBackgroundImage(@Nullable Drawable drawable);
}
