package com.yanftch.review.android.activity


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.R


class TextSwitcherActivity : AppCompatActivity() {
    private val TAG = "debug_ViewFlipperActivity"

    private var list: ArrayList<String> = arrayListOf()
    private lateinit var mTextSwitcher: TextSwitcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_flipper)
        mTextSwitcher = findViewById(R.id.test_switcher)

        findViewById<View>(R.id.btn_start).setOnClickListener {
            list.clear()
            for (i in 0..2) {
                list.add("索引值是=$i")
            }
            initTextSwitcher()
            startTurns()
        }
        var countLocal = 3
        findViewById<View>(R.id.btn_add).setOnClickListener {
            Log.e(TAG, "添加前：list.size=${list.size}")
            list.add("新的索引值是 $countLocal")
            countLocal++
            Log.e(TAG, "添加后：list.size=${list.size}")

            if (list.size == 1) {
                // 如果大于0，则表明添加数据之前，size=0，表示已经停止滚动了
                startTurns()
            } else {
                Log.e(TAG, "正在滚动，直接更新数据。。。")
            }
        }

    }

    private val UPDATE_TEXT = 1001

    private fun startTurns() {
        handler.sendEmptyMessageDelayed(UPDATE_TEXT, 2000)
    }

    private val handler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                UPDATE_TEXT -> {
                    // 更新TextView的内容
                    val removeAt = list.removeAt(0)
                    Log.e(TAG, "更新TextView的内容: list.size=${list.size}, removeAt=$removeAt")
                    mTextSwitcher.setText(removeAt)
                    if (list.size > 0) {
                        // 重新调度消息，实现每2秒更新一次
                        sendEmptyMessageDelayed(UPDATE_TEXT, 2000)
                    }
                }
            }
        }
    }

    private fun initTextSwitcher() {
        mTextSwitcher.setFactory {
            val textView = TextView(this@TextSwitcherActivity)
            textView.setLayoutParams(
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
                )
            );
            textView.setGravity(Gravity.CENTER);
            textView.textSize = 16f
            textView
        }
        mTextSwitcher.setInAnimation(this, R.anim.anim_marquee_in)
        mTextSwitcher.setOutAnimation(this, R.anim.anim_marquee_out)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}