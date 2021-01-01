package com.yanftch.review.android.view.nested_scrollview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.yanftch.review.R;

public class MyNestedScrollViewHeaderScale extends NestedScrollView {
    public MyNestedScrollViewHeaderScale(@NonNull Context context) {
        super(context);
    }

    public MyNestedScrollViewHeaderScale(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNestedScrollViewHeaderScale(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    // 下拉的最大状态值
    private static final float MAX_SCALE_RATIO = 1.8f;
    private int mPullDownY = -1;
    private boolean mIsPullDown = false;
    // 图片初始大小
    private int originHeight;
    private int originWidth;
    // 图片所在的头部控件
    private View headerView;


    private void init() {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // 初始化头部控件
        headerView = findViewById(R.id.scroll_header_view);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (headerView == null) {
            return super.onTouchEvent(ev);
        }

        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_MOVE:
                // 如果当前头部图片顶部没有在屏幕的顶部，与屏幕顶部有偏移，那么不应该做缩放动画
                if (getScrollY() != 0) {
                    return super.onTouchEvent(ev);
                }
                if (!mIsPullDown && getScrollY() == 0 && mPullDownY == -1) {
                    // 如果图片顶部和屏幕顶部重合，那么此时可以监控用户触摸事件
                    mPullDownY = (int) ev.getY();
                    return super.onTouchEvent(ev);
                } else if (!mIsPullDown) {
                    // 判断用户当前是否实在做滑动还是普通的触摸事件
                    int diff = (int) (ev.getY() - mPullDownY);
                    if (diff < 0) { // 向上推动，这时不应该做动画
                        return super.onTouchEvent(ev);
                    } else { // 向下拉动
                        // 记录下图片的原始大小
                        mIsPullDown = true;
                        originHeight = headerView.getHeight();
                        originWidth = headerView.getWidth();
                    }
                }

                // 如果用户正在滑动而且当前位置在用户开始滑动的位置下方
                int diff = (int) (ev.getY() - mPullDownY);
                if (mIsPullDown && diff > 0) {
                    // 调整layoutParams改变控件的大小
                    int height = (int) (originHeight + diff * 0.5f);
                    float ratio = (float) height / originHeight;
                    ratio = ratio > MAX_SCALE_RATIO ? MAX_SCALE_RATIO : ratio;
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) headerView.getLayoutParams();
                    layoutParams.width = (int) (originWidth * ratio);
                    layoutParams.height = (int) (originHeight * ratio);
                    layoutParams.leftMargin = -(layoutParams.width - originWidth) / 2;
                    headerView.requestLayout();
                    return true;
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                // 如果用户放开滑动，那么使用属性动画回到最初状态，
                mIsPullDown = false;
                mPullDownY = -1;
                float startRatio = (float) headerView.getLayoutParams().width / originWidth;
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(startRatio, 1.0f).setDuration(300);

                // 回去的时候先加速再减速
                valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        // 根据中间状态修改图片的大小
                         ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) headerView.getLayoutParams();
                        layoutParams.width = (int) ((float) animation.getAnimatedValue() * originWidth);
                        layoutParams.height = (int) ((float) animation.getAnimatedValue() * originHeight);
                        layoutParams.leftMargin = -(layoutParams.width - originWidth) / 2;
                        headerView.requestLayout();
                    }
                });
                valueAnimator.start();
                break;
        }
        return super.onTouchEvent(ev);
    }

}
