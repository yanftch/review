package com.yanftch.review.ziroom.ui;


import com.facebook.imagepipeline.image.QualityInfo;

public class ImageQualityInfo
{
    private QualityInfo mQualityInfo;
    public ImageQualityInfo(QualityInfo info)
    {
        this.mQualityInfo = info;
    }


    public int getQuality() {
        return mQualityInfo.getQuality();
    }

    public boolean isOfGoodEnoughQuality() {
        return mQualityInfo.isOfGoodEnoughQuality();
    }

    public boolean isOfFullQuality() {
        return mQualityInfo.isOfFullQuality();
    }
}
