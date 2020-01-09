package com.yanftch.review.android.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import com.yanftch.review.android.utils.toActionName

/**
 *
 * User : yanftch
 * Date : 2019-10-28
 * Time : 12:10
 * Desc :
 */
class EventViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        val name = ev?.action.toActionName("ViewGroup")
        Log.e("debug_EventViewGroup", "dispatchTouchEvent:    $name")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        val name = ev?.action.toActionName("ViewGroup")
        Log.e("debug_EventViewGroup", "onInterceptTouchEvent: $name")
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val name = event?.action.toActionName("ViewGroup")
        Log.e("debug_EventViewGroup", "onTouchEvent:          $name")
        return super.onTouchEvent(event)
    }
}