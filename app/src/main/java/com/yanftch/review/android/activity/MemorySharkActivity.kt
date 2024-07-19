package com.yanftch.review.android.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.R

/**
 * Author : yanfeng
 * Date : 2024/7/19
 * Time : 09:04
 * Desc : 内存抖动实例
 */
class MemorySharkActivity : AppCompatActivity() {
    private var handler: Handler? = null
    private val TAG = "debug_MemorySharkActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_shark)

        handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val arr = arrayOfNulls<String>(1000000)
                Log.e(TAG, "handleMessage: 创建对象")
                handler?.sendEmptyMessageDelayed(10, 500)
            }
        }

        findViewById<View>(R.id.btn1).setOnClickListener {
            handler?.sendEmptyMessage(10)
        }
    }
}