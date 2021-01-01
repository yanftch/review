package com.yanftch.review.android.pages.smartrefreshlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.yanftch.review.R;

@SuppressLint("LongLogTag")
public class SmartNestedScrollView extends NestedScrollView {
    private static final String TAG = "debug_SmartNestedScrollView";

    private View mTarget;
    private float mTitleHeight;


    public SmartNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public SmartNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mTitleHeight = context.getResources().getDisplayMetrics().density * 48;
    }

    public SmartNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        return super.onStartNestedScroll(child, target, axes, type);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int nestedScrollAxes) {
        Log.e(TAG, "onStartNestedScroll: nestedScrollAxes = " + nestedScrollAxes);

        return super.onStartNestedScroll(child, target, nestedScrollAxes);
    }
    public interface OnSmartListener {
        void onSmartScrollListener(int scrollY, int yLimit);
    }
    private OnSmartListener mOnSmartListener;
    public void setOnSmartListener(OnSmartListener listener) {
        this.mOnSmartListener = listener;
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(target, dx, dy, consumed, type);
        int scrollY = getScrollY();
        int scrollYLimit = getScrollYLimit();
        if (mOnSmartListener != null) {
            mOnSmartListener.onSmartScrollListener(scrollY, scrollYLimit);
        }
        Log.e(TAG, "onNestedPreScroll: dy = " + dy + ", consumed[1] = " + consumed[1] + ", type = " + type + ", scrollY = " + scrollY + ", scrollYLimit = " + scrollYLimit);

        int consumedY = dy;

        if (dy > 0) {
            // 表示 上滑
            if (scrollY < scrollYLimit) {
                // 滑动距离，还没有到 目标view
                if (scrollY + dy > scrollYLimit) {
                    //不过渡消耗
                    consumedY = scrollYLimit - scrollY;
                }
            }
        }

        if (dy < 0) {
            // 表示 下滑

        }
        if (scrollY < scrollYLimit) {
            //targetView未滑动到顶部
            //滑动
            scrollBy(0, consumedY);
            consumed[1] = consumedY;
        }

    }


    private View getTargetView() {
        if (mTarget == null) {
            mTarget = findViewById(R.id.ll_target_view);
        }
        return mTarget;
    }

    /**
     * target view  的顶部，距离屏幕上方，600px的距离
     * titleHeight = 144px
     * target view 的高度也是 144px
     * top = 600
     * mTitleHeight = 144
     * top - mTitleHeight = 456
     */

    private int getScrollYLimit() {
        View targetView = getTargetView();
        if (targetView != null) {
            int top = targetView.getTop();
//            Log.e(TAG, "getScrollYLimit: top - mTitleHeight = " + (top - mTitleHeight) + ", top = " + top + ", mTitleHeight = " + mTitleHeight);
            return (int) (top - mTitleHeight);
        }
        return 0;
    }

}
