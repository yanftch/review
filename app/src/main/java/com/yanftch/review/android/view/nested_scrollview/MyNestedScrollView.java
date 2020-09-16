package com.yanftch.review.android.view.nested_scrollview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;

@SuppressLint("LongLogTag")
public class MyNestedScrollView extends NestedScrollView {
    private static final String TAG = "debug_MyNestedScrollView";

    final int MAX_SCROLL_LENGTH = 900;
    /**
     * 该控件滑动的高度，高于这个高度后交给子滑动控件
     */
    int mParentScrollHeight = 756;
    int mScrollY;

    private View mTarget;
    private float mTitleHeight;

    public MyNestedScrollView(Context context) {
        super(context);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTitleHeight = context.getResources().getDisplayMetrics().density * 48;
    }

    public MyNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private View getTargetView() {
        if (mTarget == null) {
            mTarget = findViewById(R.id.ll_target_view);
        }
        return mTarget;
    }

    /**
     * target view  的顶部，距离屏幕上方，900px的距离
     * titleHeight = 144px
     * target view 的高度也是 144px
     * target view 网上滑动的时候，滑动到 900-144=756 的时候，就要将滑动事件传递给子视图了,非，还是由父视图消费滑动事件
     *
     */

    private int getScrollYLimit() {
        View targetView = getTargetView();
        if (targetView != null) {
            int top = targetView.getTop();
            Log.e(TAG, "getScrollYLimit: top - mTitleHeight = " + (top - mTitleHeight) + ", top = " + top + ", mTitleHeight = " + mTitleHeight);
            return (int) (top - mTitleHeight);
        }
        return 0;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        Log.e(TAG, "onStartNestedScroll: " + ", type = " + type);

        // 如果内部的子视图，是RV，则只支持垂直方向的嵌套滑动
        if (target instanceof RecyclerView) {
            if (type == ViewCompat.TYPE_TOUCH) {
//                mNewTouch = true;
            }
            return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            View targetView = getTargetView();
            if (targetView != null) {
                int scrollYLimit = getScrollYLimit();
                int scrollY = getScrollY();

                if (scrollY == scrollYLimit) {
                    return false;
                }
            }
        }
        return super.onInterceptTouchEvent(ev);
    }


    /**
     * 最重要的方法
     */
    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
//        Log.e(TAG, "onNestedPreScroll: " + ", dx = " + dx + ", dy = " + dy + ", consumed = " + Arrays.toString(consumed) + ", type = " + type);
        int scrollYLimit = getScrollYLimit();
        int scrollY = getScrollY(); // 页面的滚动距离
        boolean isHeaderVisible = false;
        if (dy>0 && scrollY < scrollYLimit) {
            isHeaderVisible = true;
        } else {
            isHeaderVisible = false;
        }

        if ((dy>0 && scrollY< scrollYLimit ) || (dy<0 && scrollY>0)) {
            scrollBy(0, dy);
            consumed[1] = dy;
        } else {
        }

        Log.e(TAG, "onNestedPreScroll: scrollY = " + scrollY + ", scrollYLimit = " + scrollYLimit + ", dy = " + dy + ", isHeaderVisible= " + isHeaderVisible);

        // 表示 上滑
//        if (dy > 0) {
//            if (scrollY < scrollYLimit) {
//                // 表示 target view 还没有滑动到顶部，此时需要继续滑动
//                isHeaderVisible = true;
//            } else {
//                isHeaderVisible = false;
//            }
//
//        } else if (dy < 0) {
//            // 表示 下滑
//
//
//        }
//        if (isHeaderVisible) {
//            consumed[1] = dy;
//            scrollBy(0, dy);
//        }

//
//        super.onNestedPreScroll(target, dx, dy, consumed, type);
    }


    @Override
    public boolean onNestedFling(@NonNull View target, float velocityX, float velocityY, boolean consumed) {
        Log.e(TAG, "onNestedFling: " + ", velocityX = " + velocityX + ", velocityY = " + velocityY + ", consumed = " + consumed);
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(@NonNull View target, float velocityX, float velocityY) {
        Log.e(TAG, "onNestedPreFling:  " + ", velocityX = " + velocityX + ", velocityY = " + velocityY);
        return super.onNestedPreFling(target, velocityX, velocityY);
    }
}