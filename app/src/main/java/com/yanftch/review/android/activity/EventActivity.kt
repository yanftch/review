package com.yanftch.review.android.activity

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yanftch.review.R
import com.yanftch.review.android.utils.getEventName
import com.yanftch.review.android.widget.ChildView
import com.yanftch.review.android.widget.ParentViewGroup

class EventActivity : AppCompatActivity() {
    private val TAG = "debug_EventActivity"
    private lateinit var parentViewGroup: ParentViewGroup
    private lateinit var childView: ChildView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        parentViewGroup = findViewById(R.id.parent)
        childView = findViewById(R.id.child)
        findViewById<View>(R.id.btn1).setOnClickListener {
            childView.requestLayout()
        }
        findViewById<View>(R.id.btn2).setOnClickListener {
            childView.invalidate()
        }
//        childView.setOnClickListener {
//            Log.e(TAG, "onCreate: onClick...")
//        }

//        childView.setOnTouchListener { v, event ->
//            Log.e(TAG, "childView  setOnTouchListener: " + event.getEventName())
//            true
//        }
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.e(TAG, "dispatchTouchEvent: " + event.getEventName())
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e(TAG, "onTouchEvent: " + event.getEventName())
        return super.onTouchEvent(event)
    }
}