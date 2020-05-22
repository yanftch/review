package com.yanftch.review.android.pages;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yanftch.review.R;
import com.yanftch.review.android.view.MyNestedScrollView;
import com.yanftch.review.android.view.RoundProgressBar;

public class DiyViewActivity extends AppCompatActivity implements MyNestedScrollView.OnTouchCallback {
    private RoundProgressBar mRoundProgressBar;
    private TextView mTvQuestion;
    private MyNestedScrollView mMyNestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_view);
        mMyNestedScrollView = findViewById(R.id.nested_scroll);
        mMyNestedScrollView.setTouchCallback(this);

        mTvQuestion = findViewById(R.id.tv_question);
        mTvQuestion.setOnClickListener(v -> {
            ObjectAnimator.ofFloat(mTvQuestion, "translationX", 0, 200)
                    .setDuration(3000)
                    .start();
        });

        initProgressBar();
        double d = 106.1415926;
        String s = d + "";
        String s2 = String.valueOf(d);

        Log.e("debug_", "s == " + s + ", s2 = " + s2);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                ObjectAnimator.ofFloat(mTvQuestion, "translationX", 0, 200)
                        .setDuration(3000)
                        .start();
                Log.e("debug_DiyViewActivity", "onTouchEvent: down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("debug_DiyViewActivity", "onTouchEvent: move.........");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("debug_DiyViewActivity", "onTouchEvent: up");
                break;
            default:
                break;
        }

        return super.onTouchEvent(event);
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

    private boolean canMove = false;
    private double mTvWidth;

    @Override
    public void onTouchDown(MotionEvent event) {
        canMove = true;
        Log.e("debug_DiyViewActivity", "onTouchDown: " + mTvQuestion.getWidth());
    }

    @Override
    public void onTouchMove(MotionEvent event) {
        Log.e("debug_DiyViewActivity", "onTouchMove: " + event.getY());
        if (canMove) {
            ObjectAnimator.ofFloat(mTvQuestion, "translationX", 0, 200)
                    .setDuration(1000)
                    .start();
            canMove = false;
        }
    }

    @Override
    public void onTouchUp(MotionEvent event) {
        ObjectAnimator.ofFloat(mTvQuestion, "translationX", 200, 0)
                .setDuration(1000)
                .start();
    }
}
