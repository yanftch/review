package com.yanftch.review.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.yanftch.review.utils.getEventName

class ChildView  @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attributeSet, defStyleAttr) {
    private val TAG = "debug_ChildView"

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.e(TAG, "dispatchTouchEvent: " + event.getEventName())
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e(TAG, "onTouchEvent: " + event.getEventName())
        return super.onTouchEvent(event)
    }

}