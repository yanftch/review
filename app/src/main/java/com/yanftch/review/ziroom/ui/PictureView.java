package com.yanftch.review.ziroom.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @inheritDoc
 * */
public class PictureView extends SimpleDraweeView implements IImageHandler
{
    private static final String TAG = "PictureView";
    private ImageHandlerBuilder mImageBuilder;

    public PictureView(Context context)
    {
        super(context);
        Log.i(TAG, "one params");
        mImageBuilder = ImageHandlerBuilder.newInstance(context);
    }

    public PictureView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Log.i(TAG, "two params");
        mImageBuilder = ImageHandlerBuilder.newInstance(context);
    }

    public PictureView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Log.i(TAG, "three params");
        mImageBuilder = ImageHandlerBuilder.newInstance(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PictureView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public PictureView setImageUri(String uri) {
        mImageBuilder.setImageUri(uri);
        return this;
    }

    @Override
    public PictureView setImageUri(int resId) {
        mImageBuilder.setImageUri(resId);
        return this;
    }

    @Override
    public PictureView setLocalImageUri(String filepath) {
        mImageBuilder.setLocalImageUri(filepath);
        return this;
    }

    @Override
    public PictureView setImageUri(Uri uri) {
        mImageBuilder.setImageUri(uri);
        return this;
    }

    @Override
    public PictureView setActualImageScaleType(int scaleType) {
        mImageBuilder.setActualImageScaleType(scaleType);
        return this;
    }

    public PictureView setFadeDuration(int fadeDuration) {
        mImageBuilder.setFadeDuration(fadeDuration);
        return this;
    }

    @Override
    public PictureView setPlaceHolderImage(int resId) {
        mImageBuilder.setPlaceHolderImage(resId);
        return this;
    }

    @Override
    public PictureView setPlaceHolderImage(Drawable drawable) {
        mImageBuilder.setPlaceHolderImage(drawable);
        return this;
    }

    @Override
    public PictureView setPlaceHolderImage(int resId, int scaleType) {
        mImageBuilder.setPlaceHolderImage(resId, scaleType);
        return this;
    }

    @Override
    public PictureView setPlaceHolderImage(Drawable drawable, int scaleType) {
        mImageBuilder.setPlaceHolderImage(drawable, scaleType);
        return this;
    }

    @Override
    public PictureView setPlaceHolderImageScaleType(int scaleType) {
        mImageBuilder.setPlaceHolderImageScaleType(scaleType);
        return this;
    }

    @Override
    public PictureView setDesiredAspectRatio(float ratio) {
        mImageBuilder.setDesiredAspectRatio(ratio);
        return this;
    }

    @Override
    public PictureView setFailureImage(int resId) {
        mImageBuilder.setFailureImage(resId);
        return this;
    }

    @Override
    public PictureView setFailureImage(Drawable drawable) {
        mImageBuilder.setFailureImage(drawable);
        return this;
    }

    @Override
    public PictureView setFailureImage(int resId, int scaleType) {
        mImageBuilder.setFailureImage(resId, scaleType);
        return this;
    }

    @Override
    public PictureView setFailureImage(Drawable drawable, int scaleType) {
        mImageBuilder.setFailureImage(drawable, scaleType);
        return this;
    }

    @Override
    public PictureView setFailureImageScaleType(int scaleType) {
        mImageBuilder.setFailureImageScaleType(scaleType);
        return this;
    }

    @Override
    public PictureView setProgressBarImage(int resId) {
        mImageBuilder.setProgressBarImage(resId);
        return this;
    }

    @Override
    public PictureView setProgressBarImage(Drawable drawable) {
        mImageBuilder.setProgressBarImage(drawable);
        return this;
    }

    @Override
    public PictureView setProgressBarImage(int resId, int scaleType) {
        mImageBuilder.setProgressBarImage(resId, scaleType);
        return this;
    }

    @Override
    public PictureView setProgressBarImage(Drawable drawable, int scaleType) {
        mImageBuilder.setProgressBarImage(drawable, scaleType);
        return this;
    }

    @Override
    public PictureView setProgressBarImageScaleType(int scaleType) {
        mImageBuilder.setProgressBarImageScaleType(scaleType);
        return this;
    }

    @Override
    public PictureView setRetryImage(int resId) {
        mImageBuilder.setRetryImage(resId);
        return this;
    }

    @Override
    public PictureView setRetryImage(Drawable drawable) {
        mImageBuilder.setRetryImage(drawable);
        return this;
    }

    @Override
    public PictureView setRetryImage(int resId, int scaleType) {
        mImageBuilder.setRetryImage(resId, scaleType);
        return this;
    }

    @Override
    public PictureView setRetryImage(Drawable drawable, int scaleType) {
        mImageBuilder.setRetryImage(drawable, scaleType);
        return this;
    }

    @Override
    public PictureView setRetryImageScaleType(int scaleType) {
        mImageBuilder.setRetryImageScaleType(scaleType);
        return this;
    }

    @Override
    public PictureView setOverlay(Drawable drawable) {
        mImageBuilder.setOverlay(drawable);
        return this;
    }

    @Override
    public IImageHandler setOverlays(List drawables) {
        mImageBuilder.setOverlays(drawables);
        return this;
    }

    @Override
    public PictureView setPressedStateOverlay(Drawable drawable) {
        mImageBuilder.setPressedStateOverlay(drawable);
        return this;
    }

    @Override
    public PictureView setRoundAsCircle(boolean bool) {
        mImageBuilder.setRoundAsCircle(bool);
        return this;
    }

    @Override
    public PictureView setCornersRadius(float radius) {
        mImageBuilder.setCornersRadius(radius);
        return this;
    }

    @Override
    public PictureView setCornersRadii(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        mImageBuilder.setCornersRadii(topLeft, topRight, bottomRight, bottomLeft);
        return this;
    }

    @Override
    public PictureView setBorder(int color, float width) {
        mImageBuilder.setBorder(color, width);
        return this;
    }

    @Override
    public PictureView setControllerListener(IImageHandleListener listener) {
        mImageBuilder.setControllerListener(listener);
        return this;
    }

    @Override
    public PictureView setPostProcessor(ImageProcessor processor) {
        mImageBuilder.setPostProcessor(processor);
        return this;
    }

    @Override
    public PictureView setResizeOption(int width, int height) {
        mImageBuilder.setResizeOption(width, height);
        return this;
    }

    @Override
    public PictureView setAutoPlayAnimations(boolean enabled) {
        mImageBuilder.setAutoPlayAnimations(enabled);
        return this;
    }

    @Override
    public PictureView setTapToRetryEnabled(boolean enabled) {
        mImageBuilder.setTapToRetryEnabled(enabled);
        return this;
    }

    /*
    * 由于setHierarchy比较耗时，这里提供该方法来避免频繁的去做setHierarchy操作
    * */
    public void display()
    {
        mImageBuilder.display(this, false);
    }

    public void display(boolean needOriginSize)
    {
        mImageBuilder.display(this, needOriginSize);
    }

    @Override
    public PictureView display(PictureView view) {
        mImageBuilder.display(this);
        return this;
    }

    @Override
    public PictureView display(PictureView view, boolean needOriginSize) {
        mImageBuilder.display(this, needOriginSize);
        return this;
    }

    @Override
    public PictureView setProgressiveRenderingEnabled(boolean enabled) {
        mImageBuilder.setProgressiveRenderingEnabled(enabled);
        return this;
    }

    @Override
    public PictureView fetchImage(ImageFetchCallBack callBack) {
        mImageBuilder.fetchImage(callBack);
        return this;
    }

    @Override
    public EncodeImageInfo getOrignalImageInfo() {
        return mImageBuilder.getOrignalImageInfo();
    }

    @Override
    public void getOrignalImageInfo(ImageFetchCallBack callBack) {
        mImageBuilder.getOrignalImageInfo(callBack);
    }

    @Override
    public PictureView clear() {
        if(mImageBuilder != null)
        {
            mImageBuilder.clear();
            mImageBuilder = null;
        }

        return null;
    }

    @Override
    public PictureView setAutoRotateEnabled(boolean enabled) {
        mImageBuilder.setAutoRotateEnabled(enabled);
        return this;
    }

    @Override
    public PictureView setImageBlur(int blurRadius) {
        mImageBuilder.setImageBlur(blurRadius);
        return this;
    }

    @Override
    public PictureView setImageBlur(int iterations, int blurRadius) {
        mImageBuilder.setImageBlur(iterations, blurRadius);
        return this;
    }

    @Override
    public boolean isHasDiskCache(String url) {
        return mImageBuilder.isHasDiskCache(url);
    }

    @Override
    public PictureView setBackgroundImage(@Nullable Drawable drawable) {
        mImageBuilder.setBackgroundImage(drawable);
        return this;
    }
}
