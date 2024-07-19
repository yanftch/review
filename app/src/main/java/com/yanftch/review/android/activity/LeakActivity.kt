package com.yanftch.review.android.activity

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yanftch.review.R

class LeakActivity : AppCompatActivity() {
    private val TAG = "debug_LeakActivity"
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak)
        handler = Handler()
        findViewById<View>(R.id.btn1).setOnClickListener {
            handler.postDelayed({
                Log.e(TAG, "onCreate: handler延迟 10s 发送一个消息。。。")
            }, 10 * 1000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: 页面销毁。。。")
    }
}