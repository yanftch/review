package com.yanftch.review.android.view.nested_scrollview;

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

public class SubHomeNestedScrollView extends PullDownNestedScrollView {
    private static final String TAG = "debug_SubHomeNestedScrollView";

    /**
     * 新的touch
     */
    private boolean mNewTouch = true;
    /**
     * 新的fling
     */
    private boolean mNewFling = false;
    /**
     * fling刚触发时的scrollY
     */
    private int mFlingFristTimeScrollY = 0;

    private View mTarget;
    private float mTitleHeight;

    public SubHomeNestedScrollView(Context context) {
        super(context);
    }

    public SubHomeNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTitleHeight = context.getResources().getDisplayMetrics().density * 48;
    }

    public SubHomeNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        if (target instanceof RecyclerView) {
            if (type == ViewCompat.TYPE_TOUCH) {
                mNewTouch = true;
            }
            return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
        }
        return false;
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        //targetView在父控件中的y坐标
        int scrollYLimit = getScrollYLimit();
        int scrollY = getScrollY(); // 页面的滚动距离
        Log.e(TAG, "onNestedPreScroll: scrollY = " + scrollY + ", scrollYLimit = " + scrollYLimit + ", dy = " + dy);

        if (mNewTouch) {
            mNewTouch = false;
        }

        int consumedY = dy;
        if (dy > 0) {
            //上滑
            if (scrollY < scrollYLimit) {
                //targetView未滑动到顶部
                //继续滑动
                if (scrollY + dy > scrollYLimit) {
                    //不过渡消耗
                    consumedY = scrollYLimit - scrollY;
                }
            }
        } else if (dy < 0 && type == ViewCompat.TYPE_NON_TOUCH) {
            //下滑&&fling
            if (mNewFling) {
                mNewFling = false;
                mFlingFristTimeScrollY = scrollY;
            } else {
                if (scrollY == scrollYLimit && mFlingFristTimeScrollY < scrollY) {
                    //避免反弹
                    consumed[1] = dy;
                    return;
                }
            }
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
     * target view  的顶部，距离屏幕上方，900px的距离
     * titleHeight = 144px
     * target view 的高度也是 144px
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
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        mNewFling = true;
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

}
