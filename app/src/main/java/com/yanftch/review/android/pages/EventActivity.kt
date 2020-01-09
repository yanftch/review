package com.yanftch.review.android.pages

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.R
import com.yanftch.review.android.utils.toActionName
import kotlinx.android.synthetic.main.activity_event.*

/**
 * Author : yanftch
 * Date   : 2019-10-25
 * Time   : 16:51
 * Desc   : 事件分发 demo
 */

class EventActivity : AppCompatActivity() {
    private lateinit var handler: Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("debug_EventActivity", "onCreate: ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        tv_event_child.setOnClickListener {
            Log.e("debug_EventActivity", "onCreate: click")
        }
        tv_event_child.setOnTouchListener { v, event ->
//            Log.e("debug_EventActivity", "onCreate: touch-----${event.action}")
            true
        }
        btn_requestLayout.setOnClickListener {
            tv_event_child.requestLayout()
        }
        btn_invalidate.setOnClickListener {
            tv_event_child.invalidate()
        }
        btn_postInvalidate.setOnClickListener {
            tv_event_child.postInvalidate()
        }
        btn_postInvalidate_new.setOnClickListener {
            Runnable {
                Log.e("debug_EventActivity", "onCreate: ")
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val name = event?.action.toActionName("Activity")
        Log.e("debug_EventActivity", "onTouchEvent:          $name")
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        val name = ev?.action.toActionName("Activity")
        Log.e("debug_EventActivity", "dispatchTouchEvent:    $name ")
        return super.dispatchTouchEvent(ev)
    }

//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        Log.e("debug_EventActivity", "onWindowFocusChanged: hasFocus = $hasFocus")
//    }
//
//    override fun onStop() {
//        Log.e("debug_EventActivity", "onStop: ")
//        super.onStop()
//    }
//
//    override fun onDestroy() {
//        Log.e("debug_EventActivity", "onDestroy: ")
//        super.onDestroy()
//    }
//
//    override fun onStart() {
//        Log.e("debug_EventActivity", "onStart: ")
//        super.onStart()
//    }
//
//    override fun onResume() {
//        Log.e("debug_EventActivity", "onResume: ")
//        super.onResume()
//    }
}
