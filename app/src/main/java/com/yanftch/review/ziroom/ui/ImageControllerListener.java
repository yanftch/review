package com.yanftch.review.ziroom.ui;

import android.graphics.drawable.Animatable;

import com.facebook.drawee.controller.ControllerListener;

public class ImageControllerListener implements ControllerListener<com.facebook.imagepipeline.image.ImageInfo> {

    private IImageHandleListener mImageHandleListener;
    public ImageControllerListener(IImageHandleListener imageHandleListener)
    {
        this.mImageHandleListener = imageHandleListener;
    }

    @Override
    public void onSubmit(String id, Object callerContext) {
        mImageHandleListener.onSubmit(id, callerContext);
    }

    @Override
    public void onFinalImageSet(String id, com.facebook.imagepipeline.image.ImageInfo imageInfo, Animatable animatable) {
        mImageHandleListener.onFinalImageSet(id, new ImageInfo(imageInfo), animatable);
    }

    @Override
    public void onIntermediateImageSet(String id, com.facebook.imagepipeline.image.ImageInfo imageInfo) {
        mImageHandleListener.onIntermediateImageSet(id, new ImageInfo(imageInfo));
    }

    @Override
    public void onIntermediateImageFailed(String id, Throwable throwable) {
        mImageHandleListener.onIntermediateImageFailed(id, throwable);
    }

    @Override
    public void onFailure(String id, Throwable throwable) {
        mImageHandleListener.onFailure(id, throwable);
    }

    @Override
    public void onRelease(String id) {

    }
}
