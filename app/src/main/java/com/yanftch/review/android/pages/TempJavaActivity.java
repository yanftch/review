package com.yanftch.review.android.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yanftch.review.R;

public class TempJavaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_java);
        findViewById(R.id.btn_show).setOnClickListener(v -> {
            Intent intent = new Intent(this, TrasActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });
    }

    private boolean isSpeaker = false;

    // 上
    private LinearLayout mLlTopControlLayout;
    // 上左
    private LinearLayout mLlTopLeftLayout;
    private ImageView mIvTopLeftImage;
    private TextView mTvTopLeftText;
    // 上中
    private LinearLayout mLlTopMiddleLayout;
    private ImageView mIvTopMiddleImage;
    private TextView mTvTopMiddleText;
    // 上右
    private LinearLayout mLlTopRightLayout;
    private ImageView mIvTopRightImage;
    private TextView mTvTopRightText;

    // 下
    private LinearLayout mLlBottomControlLayout;
    // 上左
    private LinearLayout mLlBottomLeftLayout;
    private ImageView mIvBottomLeftImage;
    private TextView mTvBottomLeftText;
    // 上中
    private LinearLayout mLlBottomMiddleLayout;
    private ImageView mIvBottomMiddleImage;
    private TextView mTvBottomMiddleText;
    // 上右
    private LinearLayout mLlBottomRightLayout;
    private ImageView mIvBottomRightImage;
    private TextView mTvBottomRightText;


    /**
    * control widget 初始化
    */
    private void initControlView() {
        mLlTopControlLayout = findViewById(R.id.top_control_layout);

        mLlTopLeftLayout = findViewById(R.id.top_left_layout);
        mIvTopLeftImage = findViewById(R.id.top_left_img);
        mTvTopLeftText = findViewById(R.id.top_left_txt);

        mLlTopMiddleLayout = findViewById(R.id.top_middle_layout);
        mIvTopMiddleImage = findViewById(R.id.top_middle_img);
        mTvTopMiddleText = findViewById(R.id.top_middle_txt);

        mLlTopRightLayout = findViewById(R.id.top_right_layout);
        mIvTopRightImage = findViewById(R.id.top_right_img);
        mTvTopRightText = findViewById(R.id.top_right_txt);

        // 下
        mLlBottomControlLayout = findViewById(R.id.bottom_control_layout);

        mLlBottomLeftLayout = findViewById(R.id.bottom_left_layout);
        mIvBottomLeftImage = findViewById(R.id.bottom_left_img);
        mTvBottomLeftText = findViewById(R.id.bottom_left_txt);

        mLlBottomMiddleLayout = findViewById(R.id.bottom_middle_layout);
        mIvBottomMiddleImage = findViewById(R.id.bottom_middle_img);
        mTvBottomMiddleText = findViewById(R.id.bottom_middle_txt);

        mLlBottomRightLayout = findViewById(R.id.bottom_right_layout);
        mIvBottomRightImage = findViewById(R.id.bottom_right_img);
        mTvBottomRightText = findViewById(R.id.bottom_right_txt);

        initListener();
    }

    private void initListener() {
        mLlTopLeftLayout.setOnClickListener(this);
        mLlTopLeftLayout.setClickable(true);
        mLlTopMiddleLayout.setOnClickListener(this);
        mLlTopMiddleLayout.setClickable(true);
        mLlTopRightLayout.setOnClickListener(this);
        mLlTopRightLayout.setClickable(true);

        mLlBottomLeftLayout.setOnClickListener(this);
        mLlBottomLeftLayout.setClickable(true);
        mLlBottomMiddleLayout.setOnClickListener(this);
        mLlBottomMiddleLayout.setClickable(true);
        mLlBottomRightLayout.setOnClickListener(this);
        mLlBottomRightLayout.setClickable(true);
    }

    /**
    * 禁用操作栏按钮点击响应(如挂断后)
    */
    private void enableControlClick() {
        mLlTopLeftLayout.setClickable(false);
        mLlTopMiddleLayout.setClickable(false);
        mLlTopRightLayout.setClickable(false);

        mLlBottomLeftLayout.setClickable(false);
        mLlBottomMiddleLayout.setClickable(false);
        mLlBottomRightLayout.setClickable(false);
    }

    @Override
    public void onClick(View v) {

    }
}