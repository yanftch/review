package com.yanftch.review.android.pages;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequest;
import com.yanftch.review.R;
import com.yanftch.review.android.utils.DensityUtil;
import com.yanftch.review.android.utils.ImageUtil;
import com.yanftch.review.ziroom.ui.IImageHandleListener;
import com.yanftch.review.ziroom.ui.ImageInfo;
import com.yanftch.review.ziroom.ui.PictureView;

/**
 * User : yanftch
 * Date : 2022/5/11
 * Time : 09:25
 * Desc : PV 尝试 监听获取数据
 */

/**
 * 1.pv.setImageURI(url)
 * 2.pv.setImageUri().display()
 * 3.pv.setImageUri().setControllerListener()..display()
 * 4.pv.setController(ImageUtil.frescoResizeController(url, w, h))
 * 5.pv.setController(ImageUtil.frescoController(url))
 */
public class PictureViewActivity extends AppCompatActivity {
    private static final String TAG = "debug_PictureViewActivity";

    private String imageUrl = "https://static.runoob.com/images/demo/demo4.jpg";

    private PictureView mPictureView;
    private Button mBtnGet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_view);
        int w120 = DensityUtil.dip2px(this, 120);
        int h90 = DensityUtil.dip2px(this, 90);
        Log.e(TAG, "onCreate: w120 = " + w120 + ", h90 = " + h90);

        mPictureView = findViewById(R.id.sdv);
        mBtnGet = findViewById(R.id.btn_get);
        loadImage3();
        mBtnGet.setOnClickListener(v -> {
            // 获取 Bitmap
            getBitmapFromUrl(imageUrl, this);
            if (mShareBitmap != null) {
                int byteCount = mShareBitmap.getByteCount();
                Log.e(TAG, "onCreate: byteCount = " + byteCount);
            }
        });
    }

    /**
     * 加载图片方式1
     */
    private void loadImage1() {
        mPictureView.setImageURI(imageUrl);
    }

    private void loadImage2() {
        mPictureView.setImageUri(imageUrl).display();
    }

    private void loadImage3() {
        mPictureView.setImageUri(imageUrl).setControllerListener(new IImageHandleListener<ImageInfo>() {
            @Override
            public void onSubmit(String id, Object callerContext) {

            }

            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                Log.e(TAG, "onFinalImageSet: id = " + id + ", w " + imageInfo.getWidth() + ", h = " + imageInfo.getHeight());
            }

            @Override
            public void onIntermediateImageSet(String id, ImageInfo imageInfo) {

            }

            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {

            }

            @Override
            public void onFailure(String id, Throwable throwable) {

            }

            @Override
            public void onRelease(String id) {

            }
        }).display();
    }

    private void loadImage4() {
        mPictureView.setController(ImageUtil.frescoController(imageUrl));
    }

    private void loadImage5() {
        mPictureView.setController(ImageUtil.frescoResizeController(imageUrl, 100, 100));
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