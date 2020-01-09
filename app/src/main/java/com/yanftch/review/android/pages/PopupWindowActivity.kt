package com.yanftch.review.android.pages

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.listeners.onClick

@SuppressLint("LongLogTag")
class PopupWindowActivity : AppCompatActivity() {
    private var popupWindow: PopupWindow? = null
    private lateinit var mTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.e("debug_PopupWindowActivity", "onBackPressed: ")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.e("debug_PopupWindowActivity", "onKeyDown: ")
        return super.onKeyDown(keyCode, event)
    }

    private fun showPop() {
        popupWindow = BackPopupWindow(
            contentView4Pop(),
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        popupWindow?.showAtLocation(mTextView, 0, 0, 0)
    }

    @SuppressLint("SetTextI18n")
    private fun contentView() = UI {
        verticalLayout {
            gravity = Gravity.CENTER
            mTextView = textView {
                text = "点击显示 PopupWindow"
                textSize = 40F
                onClick {
                    showPop()
                }
            }
        }
    }.view

    @SuppressLint("SetTextI18n")
    private fun contentView4Pop() = UI {
        verticalLayout {
            backgroundResource = R.color.palette_grey_100
            textView {
                text = "POP"
                textSize = 20F
                onClick {
                }
            }
            textView {
                text = "POP"
                textSize = 20F
                onClick {
                }
            }
            textView {
                text = "CLOSE"
                textSize = 70F
                textColorResource = R.color.white
                onClick {
                    if (popupWindow?.isShowing == true) {
                        popupWindow?.dismiss()
                    }
                }
            }
            textView {
                text = "POP"
                textSize = 20F
                onClick {
                }
            }
            textView {
                text = "POP"
                textSize = 20F
                onClick {
                }
            }
        }
    }.view
}

class BackPopupWindow constructor(@NonNull contentView: View, width: Int, height: Int) :
    PopupWindow(contentView, width, height) {
    init {
        // 添加布局
        setContentView(contentView)
        //
        val bgDrable = ColorDrawable(0x00ffffff)
        this.setBackgroundDrawable(bgDrable)
        this.isFocusable = true
        contentView.isFocusable = true
        contentView.isFocusableInTouchMode = true
        contentView.setOnKeyListener { v, keyCode, event ->
            Log.e(
                "debug_BackPopupWindow",
                "onKeyListener.....: keyCode = $keyCode, event = ${event.action}"
            )
            // TODO: 2020-01-07 此方法不会回调 ，不知道需要怎么处理才会回调。
            true
        }
    }

    override fun showAtLocation(parent: View?, gravity: Int, x: Int, y: Int) {
        super.showAtLocation(parent, gravity, x, y)
        contentView.setOnKeyListener { v, keyCode, event ->
            Log.e(
                "debug_BackPopupWindow",
                "onKeyListener.....: keyCode = $keyCode, event = ${event.action}"
            )
            true
        }
    }

    override fun showAsDropDown(anchor: View?) {
        showAsDropDown(anchor, 0, 0)
    }

    override fun showAsDropDown(anchor: View?, xoff: Int, yoff: Int) {
        showAsDropDown(anchor, xoff, yoff, Gravity.TOP or Gravity.START)
    }

    override fun showAsDropDown(anchor: View?, xoff: Int, yoff: Int, gravity: Int) {
        super.showAsDropDown(anchor, xoff, yoff, gravity)
    }
}
