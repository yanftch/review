package com.yanftch.review.android.pages;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.yanftch.review.R;
import com.yanftch.review.android.utils.ImageUtil;

public class ImageLoadActivity extends AppCompatActivity {
    private static final String TAG = "debug_ImageLoadActivity";
    private SimpleDraweeView mSimpleDraweeView;
    // 5040 * 3360 实际分辨率
    private String mUrl5 = "https://image.ziroom.com/g2m3/M00/83/F0/ChAZVF-_K2qAJLTLAEwuOY9u18w434.jpg";

    private String mUrl2_5 = "https://image.ziroom.com/g2m3/M00/83/94/ChAZVF-_ENuAG5xdACXSGCeNAeE593.jpg";
    private String mImageUrl = "https://static.runoob.com/images/demo/demo4.jpg";

    private String mUrl = mImageUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_load);


        mSimpleDraweeView = findViewById(R.id.sdv);

        findViewById(R.id.btn).setOnClickListener(v -> {
            getBitmapFromUrl(mUrl, this);
            if (mShareBitmap != null) {
                int byteCount = mShareBitmap.getByteCount();
                Log.e(TAG, "onCreate: byteCount = " + byteCount);
            }
        });


//        mSimpleDraweeView.setImageURI(mUrl);

        ControllerListener mControllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                int width = imageInfo.getWidth();
                int height = imageInfo.getHeight();
                Log.e(TAG, "onFinalImageSet: width = " + width + ", height = " + height); // 图片的实际宽高像素大小


            }

        };
        DraweeController mDraweeController = Fresco.newDraweeControllerBuilder().setControllerListener(mControllerListener).setUri(mUrl).build();

//        mSimpleDraweeView.setController(mDraweeController);
        mSimpleDraweeView.setController(ImageUtil.frescoResizeController(mUrl, 960, 500));
//        mSimpleDraweeView.setController(ImageUtil.frescoController(mUrl));
        mSimpleDraweeView.post(new Runnable() {
            @Override
            public void run() {
                int width = mSimpleDraweeView.getWidth();
                int height = mSimpleDraweeView.getHeight();
                Log.e(TAG, "onCreate: width = " + width + ", height = "+ height); // UI 控件的大小  360*270
            }
        });
    }

    private Bitmap mShareBitmap;

    /**
     * 根据url获取图片
     */
    private void getBitmapFromUrl(String imgUrl, Context context) {
        ImageRequest request = ImageRequest.fromUri(imgUrl);
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        DataSource dataSource = imagePipeline.fetchDecodedImage(request, context);
        try {
            dataSource.subscribe(new BaseBitmapDataSubscriber() {
                @Override
                public void onNewResultImpl(@Nullable Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    mShareBitmap = bitmap;
                    int byteCount = bitmap.getByteCount();
                    Log.e(TAG, "onNewResultImpl: byteCount = " + byteCount);
                }

                @Override
                public void onFailureImpl(DataSource dataSource) {
                    // No cleanup required here
                }
            }, CallerThreadExecutor.getInstance());
        } finally {
            if (mShareBitmap == null) {
                mShareBitmap = BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.ic_launcher);
            }
            if (dataSource != null) {
                dataSource.close();
            }
        }
    }
}
