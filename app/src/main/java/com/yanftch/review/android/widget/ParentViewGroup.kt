package com.yanftch.review.android.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import com.yanftch.review.android.utils.getEventName

class ParentViewGroup @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attributeSet, defStyleAttr) {
    private val TAG = "debug_ParentViewGroup"

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.e(TAG, "dispatchTouchEvent: " + event.getEventName())
        return super.dispatchTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
        Log.e(TAG, "onInterceptTouchEvent: " + event.getEventName())
        return super.onInterceptTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e(TAG, "onTouchEvent: " + event.getEventName())
        return true
    }

}