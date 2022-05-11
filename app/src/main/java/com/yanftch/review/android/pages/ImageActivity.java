package com.yanftch.review.android.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanftch.review.R;

public class ImageActivity extends AppCompatActivity {
    private SimpleDraweeView mSimpleDraweeView;
    // 5040 * 3360 实际分辨率
    private String mUrl5 = "https://image.ziroom.com/g2m3/M00/83/F0/ChAZVF-_K2qAJLTLAEwuOY9u18w434.jpg";

    private String mUrl2_5 = "https://image.ziroom.com/g2m3/M00/83/94/ChAZVF-_ENuAG5xdACXSGCeNAeE593.jpg";
    private String mImageUrl = "https://static.runoob.com/images/demo/demo4.jpg";

    private String mUrl = mImageUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }
}