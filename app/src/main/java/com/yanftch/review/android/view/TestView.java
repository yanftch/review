package com.yanftch.review.android.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * User : yanftch
 * Date : 2019-08-07
 * Time : 10:52
 * Desc :
 */
public class TestView extends LinearLayout {
    private static final String TAG = "debug_TestView";

    private int mViewHeight;

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getTotalHeight();
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        getTotalHeight();
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
//        getTotalHeight();
    }


    private void setViewHeight(int height) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = height;
        requestLayout();
    }

    /**
     * 获取view的高度
     */
    private void getTotalHeight() {
        post(new Runnable() {
            @Override
            public void run() {
                if (mViewHeight <= 0) {
                    mViewHeight = getMeasuredHeight();
                }
                Log.e(TAG, "run: mViewHeight = " + mViewHeight);
                animateToShow();
            }
        });
    }

    private void animateToShow() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, mViewHeight);
        valueAnimator.setDuration(3000);
        valueAnimator.setStartDelay(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                setViewHeight((int) value);
            }
        });
        valueAnimator.start();
    }
}
