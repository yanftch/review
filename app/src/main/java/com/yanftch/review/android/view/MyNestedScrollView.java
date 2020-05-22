package com.yanftch.review.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

public class MyNestedScrollView extends NestedScrollView {

    private OnTouchCallback mOnTouchCallback;

    public void setTouchCallback(OnTouchCallback callback) {
        mOnTouchCallback = callback;
    }

    public MyNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public MyNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e("debug_MyNestedScrollView", "onTouchEvent: down");
                if (mOnTouchCallback != null) {
                    mOnTouchCallback.onTouchDown(event);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("debug_MyNestedScrollView", "onTouchEvent: move....");
                if (mOnTouchCallback != null) {
                    mOnTouchCallback.onTouchMove(event);
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.e("debug_MyNestedScrollView", "onTouchEvent: up");
                if (mOnTouchCallback != null) {
                    mOnTouchCallback.onTouchUp(event);
                }
                break;
            default:
                break;
        }

        return super.onTouchEvent(event);
    }

    public interface OnTouchCallback {

        void onTouchDown(MotionEvent event);

        void onTouchMove(MotionEvent event);

        void onTouchUp(MotionEvent event);
    }
}
