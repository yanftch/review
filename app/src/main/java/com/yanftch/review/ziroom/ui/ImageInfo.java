package com.yanftch.review.ziroom.ui;

public class ImageInfo
{
    private com.facebook.imagepipeline.image.ImageInfo mImageInfo;
    public ImageInfo(com.facebook.imagepipeline.image.ImageInfo imageInfo)
    {
        this.mImageInfo = imageInfo;
    }

    public int getWidth() {
        return mImageInfo.getWidth();
    }

    public int getHeight() {
        return mImageInfo.getHeight();
    }

    public ImageQualityInfo getQualityInfo() {

        return new ImageQualityInfo(mImageInfo.getQualityInfo());
    }
}
