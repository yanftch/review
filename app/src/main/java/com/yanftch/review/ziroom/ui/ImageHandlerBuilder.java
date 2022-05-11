package com.yanftch.review.ziroom.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;


import java.util.List;

public class ImageHandlerBuilder implements IImageHandler
{
    private FrescoImageHandle mImageHandler;

    private ImageHandlerBuilder(Context context)
    {
        mImageHandler = new FrescoImageHandle(context);
    }

    public static ImageHandlerBuilder newInstance(Context context)
    {
        return new ImageHandlerBuilder(context);
    }
    
    public ImageHandlerBuilder setImageUri(String imageUri) {
        mImageHandler.setImageUri(imageUri);
        return this;
    }
    
    public ImageHandlerBuilder setImageUri(int resId) {
        mImageHandler.setImageUri(resId);
        return this;
    }

    @Override
    public ImageHandlerBuilder setLocalImageUri(String filepath) {
        mImageHandler.setLocalImageUri(filepath);
        return this;
    }

    @Override
    public IImageHandler setImageUri(Uri uri) {
        mImageHandler.setImageUri(uri);
        return this;
    }

    public ImageHandlerBuilder setActualImageScaleType(int scaleType)
    {
        mImageHandler.setActualImageScaleType(scaleType);
        return this;
    }

    @Override
    public IImageHandler setFadeDuration(int fadeDuration) {
        mImageHandler.setFadeDuration(fadeDuration);
        return this;
    }

    public ImageHandlerBuilder setPlaceHolderImage(int resId) {
        mImageHandler.setPlaceHolderImage(resId);
        return this;
    }

    public ImageHandlerBuilder setPlaceHolderImage(Drawable drawable)
    {
        mImageHandler.setPlaceHolderImage(drawable);
        return this;
    }
    public ImageHandlerBuilder setPlaceHolderImage(int resId, int scaleType)
    {
        mImageHandler.setPlaceHolderImage(resId, scaleType);
        return this;
    }
    public ImageHandlerBuilder setPlaceHolderImage(Drawable drawable, int scaleType)
    {
        mImageHandler.setPlaceHolderImage(drawable, scaleType);
        return this;
    }
    
    public ImageHandlerBuilder setPlaceHolderImageScaleType(int scaleType) {
        mImageHandler.setPlaceHolderImageScaleType(scaleType);
        return this;
    }
    
    public ImageHandlerBuilder setDesiredAspectRatio(float ratio)
    {
        mImageHandler.setDesiredAspectRatio(ratio);
        return this;
    }
    
    public ImageHandlerBuilder setFailureImage(int resId) {
        mImageHandler.setFailureImage(resId);
        return this;
    }

    @Override
    public IImageHandler setFailureImage(Drawable drawable) {
        mImageHandler.setFailureImage(drawable);
        return this;
    }

    @Override
    public IImageHandler setFailureImage(int resId, int scaleType) {
        mImageHandler.setFailureImage(resId, scaleType);
        return this;
    }

    @Override
    public IImageHandler setFailureImage(Drawable drawable, int scaleType) {
        mImageHandler.setFailureImage(drawable, scaleType);
        return this;
    }

    public ImageHandlerBuilder setFailureImageScaleType(int scaleType) {
        mImageHandler.setPlaceHolderImageScaleType(scaleType);
        return this;
    }

    @Override
    public IImageHandler setProgressBarImage(int resId) {
        mImageHandler.setProgressBarImage(resId);
        return this;
    }

    @Override
    public IImageHandler setProgressBarImage(Drawable drawable) {
        mImageHandler.setProgressBarImage(drawable);
        return this;
    }

    @Override
    public IImageHandler setProgressBarImage(int resId, int scaleType) {
        mImageHandler.setProgressBarImage(resId, scaleType);
        return this;
    }

    @Override
    public IImageHandler setProgressBarImage(Drawable drawable, int scaleType) {
        mImageHandler.setProgressBarImage(drawable, scaleType);
        return this;
    }

    @Override
    public IImageHandler setProgressBarImageScaleType(int scaleType) {
        mImageHandler.setProgressBarImageScaleType(scaleType);
        return this;
    }

    @Override
    public IImageHandler setRetryImage(int resId) {
        mImageHandler.setRetryImage(resId);
        return this;
    }

    @Override
    public IImageHandler setRetryImage(Drawable drawable) {
        mImageHandler.setRetryImage(drawable);
        return this;
    }

    @Override
    public IImageHandler setRetryImage(int resId, int scaleType) {
        mImageHandler.setRetryImage(resId, scaleType);
        return this;
    }

    @Override
    public IImageHandler setRetryImage(Drawable drawable, int scaleType) {
        mImageHandler.setRetryImage(drawable, scaleType);
        return this;
    }

    @Override
    public IImageHandler setRetryImageScaleType(int scaleType) {
        mImageHandler.setRetryImageScaleType(scaleType);
        return this;
    }

    @Override
    public IImageHandler setOverlay(Drawable drawable) {
        mImageHandler.setOverlay(drawable);
        return this;
    }

    @Override
    public IImageHandler setPressedStateOverlay(Drawable drawable) {
        mImageHandler.setPressedStateOverlay(drawable);
        return this;
    }

    @Override
    public IImageHandler setOverlays(List list) {
        mImageHandler.setOverlays(list);
        return this;
    }

    public ImageHandlerBuilder setRoundAsCircle(boolean enabled) {
        mImageHandler.setRoundAsCircle(enabled);
        return this;
    }

    public ImageHandlerBuilder setCornersRadius(float radius)
    {
        mImageHandler.setCornersRadius(radius);
        return this;
    }

    @Override
    public ImageHandlerBuilder setCornersRadii(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        mImageHandler.setCornersRadii(topLeft, topRight, bottomRight, bottomLeft);
        return this;
    }

    @Override
    public ImageHandlerBuilder setBorder(int color, float width) {
        mImageHandler.setBorder(color, width);
        return this;
    }

    public ImageHandlerBuilder setControllerListener(IImageHandleListener listener) {
        mImageHandler.setControllerListener(listener);
        return this;
    }
    
    public ImageHandlerBuilder setPostProcessor(ImageProcessor processor) {
        mImageHandler.setPostProcessor(processor);
        return this;
    }
    
    public ImageHandlerBuilder setResizeOption(int width, int height) {
        mImageHandler.setResizeOption(width, height);
        return this;
    }
    
    public ImageHandlerBuilder setAutoPlayAnimations(boolean enabled) {
        mImageHandler.setAutoPlayAnimations(enabled);
        return this;
    }
    
    public ImageHandlerBuilder setTapToRetryEnabled(boolean enabled) {
        mImageHandler.setTapToRetryEnabled(enabled);
        return this;
    }
    
    public ImageHandlerBuilder display(PictureView view) {
        mImageHandler.display(view);
        return this;
    }

    @Override
    public IImageHandler display(PictureView view, boolean needOriginSize) {
        mImageHandler.display(view, needOriginSize);
        return this;
    }

    @Override
    public IImageHandler setProgressiveRenderingEnabled(boolean enabled) {
        mImageHandler.setProgressiveRenderingEnabled(enabled);
        return this;
    }

    @Override
    public IImageHandler fetchImage(ImageFetchCallBack callBack) {
        mImageHandler.fetchImage(callBack);
        return this;
    }

    @Override
    public EncodeImageInfo getOrignalImageInfo() {
        return mImageHandler.getOrignalImageInfo();
    }

    @Override
    public void getOrignalImageInfo(ImageFetchCallBack callBack) {
        mImageHandler.getOrignalImageInfo(callBack);
    }

    @Override
    public IImageHandler clear() {
        if(mImageHandler != null)
        {
            mImageHandler.clear();
            mImageHandler = null;
        }

        return this;
    }

    @Override
    public IImageHandler setAutoRotateEnabled(boolean enabled) {
        mImageHandler.setAutoRotateEnabled(enabled);
        return this;
    }

    @Override
    public IImageHandler setImageBlur(int blurRadius) {
        mImageHandler.setImageBlur(blurRadius);
        return this;
    }

    @Override
    public IImageHandler setImageBlur(int iterations, int blurRadius) {
        mImageHandler.setImageBlur(iterations, blurRadius);
        return this;
    }

    @Override
    public boolean isHasDiskCache(String url) {
        return mImageHandler.isHasDiskCache(url);
    }

    @Override
    public IImageHandler setBackgroundImage(@Nullable Drawable drawable) {
        return mImageHandler.setBackgroundImage(drawable);
    }
}
