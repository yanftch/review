package com.yanftch.review.ziroom.ui;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.image.ImageInfo;

public interface IImageHandleListener<INFO>
{
    public void onSubmit(String id, Object callerContext);
    public void onFinalImageSet(String id, INFO imageInfo, Animatable animatable);
    public void onIntermediateImageSet(String id, INFO imageInfo);
    public void onIntermediateImageFailed(String id, Throwable throwable);
    public void onFailure(String id, Throwable throwable);
    public void onRelease(String id);
}
