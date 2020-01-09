package com.yanftch.review.android.pages

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.UI
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout
import java.lang.ref.WeakReference

class TestActivity : AppCompatActivity() {
    private lateinit var mHandler: Handler
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView())
        mHandler = com.yanftch.review.android.pages.TestActivity.MyHandler(this)
        sharedPreferences = this.getSharedPreferences("a", Context.MODE_PRIVATE)
    }

    private fun contentView() = UI {
        verticalLayout {

            button {
                text = "send message delay 5000ms"
                onClick {
                    val message = Message.obtain()
                    message.what = 1001
                    message.obj = "send message delay 5000ms--->obj"
                    mHandler.sendMessageDelayed(message, 5000)
                }
            }
            button {
                text = "send message"
                onClick {
                    val message = Message.obtain()
                    message.what = 1002
                    message.obj = "send message--->obj"
                    mHandler.sendMessage(message)
                }
            }
        }
    }.view

    class MyHandler(context: Context? = null) : Handler() {

        private var mContextWf: WeakReference<Context?> = WeakReference(context)

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            Log.e("debug_MyHandler", "handleMessage: message===>$msg    what=${msg.what}")

            when (msg.what) {
                1001 -> {
                    showToast("1001...")
                }
                1002 -> {
                    showToast("1002...")
                }
                10044 -> {
                    showToast("10044...")
                }
                else -> {
                    showToast("else...")
                }
            }
        }

        private fun showToast(msg: String) {
            mContextWf.get()?.toast(msg)
        }
    }
}
