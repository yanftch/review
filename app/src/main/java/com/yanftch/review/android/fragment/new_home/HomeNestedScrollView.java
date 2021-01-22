package com.yanftch.review.android.fragment.new_home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;

public class HomeNestedScrollView extends NestedScrollView {

    public HomeNestedScrollView(Context context) {
        super(context);
    }

    public HomeNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 是否为推荐流
     */
    private View mRootView;

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

    private int mTop = -1;
    private int mOffset = 0;
    private View mVp;

    public void setNestedScrollState(View rootView) {
        mRootView = rootView;
        mOffset = 0;

        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public void setNestedScrollState(View rootView,int offset) {
        mRootView = rootView;
        mOffset = offset;

        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public void clear() {
        mRootView = null;
        mOffset = 0;
        mVp = null;
        mTop = -1;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            View targetView = getTargetView();
            if (targetView != null) {
                int top = getTargetViewTop();
                int scrollY = getScrollY() + mOffset;

                if (scrollY == top) {
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
        int top = getTargetViewTop();
        int scrollY = getScrollY() + mOffset;

        //上滑时，先让ScrollView滚动完。也就是ScrollView的最底部会显示出来
        if (!(dy > 0 && canScrollVertically(dy))) {
            return;
        }

        if (mNewTouch) {
            mNewTouch = false;
        }

        int consumedY = dy;
        if (scrollY < top) {
            //targetView未滑动到顶部
            //继续滑动
            if (scrollY + dy > top) {
                //不过渡消耗
                consumedY = top - scrollY;
            }
        }

        if (scrollY < top) {
            //targetView未滑动到顶部
            //滑动
            scrollBy(0, consumedY);
            consumed[1] = consumedY;
        }
    }

    private View getTargetView() {
        if (mRootView != null && mVp == null) {
            mVp = mRootView.findViewById(R.id.vp);
        }
        return mVp;
    }

    private int getTargetViewTop() {
        if (mTop != -1) {
            return mTop;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            return targetView.getTop();
        }
        return 0;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        mNewFling = true;
        return super.onNestedPreFling(target, velocityX, velocityY);
    }
}
