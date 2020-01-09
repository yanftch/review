package com.yanftch.review.android.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.yanftch.review.android.utils.toActionName

/**
 *
 * User : yanftch
 * Date : 2019-10-28
 * Time : 12:11
 * Desc :
 */
class EventView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
//    init {
//        setOnClickListener {
//            context.toast("view click")
//            Log.e("debug_EventView", ": click listener ")
//        }
//        setOnTouchListener { v, event ->
//            Log.e("debug_EventView", ": touche listener...${event.action}")
//            true
//        }
//    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        val name = event?.action.toActionName("View")
        Log.e("debug_EventView", "dispatchTouchEvent:    $name ")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val name = event?.action.toActionName("View")
        Log.e("debug_EventView", "onTouchEvent:          $name")
        return false
    }
//
//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        Log.e("debug_EventView", "onMeasure: ")
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//    }
//
//    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
//        Log.e("debug_EventView", "onLayout: ")
//        super.onLayout(changed, left, top, right, bottom)
//    }
//
//    override fun onDraw(canvas: Canvas?) {
//        Log.e("debug_EventView", "onDraw: ")
//        super.onDraw(canvas)
//    }
//
//    override fun onDetachedFromWindow() {
//        Log.e("debug_EventView", "onDetachedFromWindow: ")
//        super.onDetachedFromWindow()
//    }
//
//    override fun onAttachedToWindow() {
//        Log.e("debug_EventView", "onAttachedToWindow: ")
//        super.onAttachedToWindow()
//    }


}