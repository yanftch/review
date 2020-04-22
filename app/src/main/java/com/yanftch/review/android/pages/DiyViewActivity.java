package com.yanftch.review.android.pages;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import androidx.appcompat.app.AppCompatActivity;

import com.yanftch.review.R;
import com.yanftch.review.android.view.RoundProgressBar;

public class DiyViewActivity extends AppCompatActivity {
    private RoundProgressBar mRoundProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_view);
        initProgressBar();
        double d = 106.1415926;
        String s = d + "";
        String s2 = String.valueOf(d);

        Log.e("debug_", "s == " + s + ", s2 = " + s2);

    }

    private void initProgressBar() {
        mRoundProgressBar = findViewById(R.id.round_progress);

        mRoundProgressBar.setCircleColor(Color.parseColor("#222222"));
        mRoundProgressBar.setCircleProgressColor(Color.parseColor("#FF0000"));
        // 假设当前的比例应该是70%
        int progress = 70; // 这个是API给的进度值


        mRoundProgressBar.setProgress(progress);
        RotateAnimation lRotateAnimation = new RotateAnimation(0, 360);
        lRotateAnimation.setDuration(2000);
        lRotateAnimation.setInterpolator(new LinearInterpolator());
        lRotateAnimation.setFillAfter(true);
//        mRoundProgressBar.setAnimation(lRotateAnimation);
        RoundProgressBar.MyYAnimation lMyYAnimation = new RoundProgressBar.MyYAnimation();
        lMyYAnimation.setFillAfter(true);
//        mRoundProgressBar.setAnimation(lMyYAnimation);
    }
}
