package com.yanftch.review.android.widget

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.yanftch.review.android.utils.getEventName

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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.e(TAG, "onMeasure: ")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.e(TAG, "onLayout: ")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.e(TAG, "onDraw: ")
    }


}