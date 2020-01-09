package com.yanftch.review.android.pages

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.listeners.onClick

/**
 * 考察静态添加和动态添加的生命周期的不同
 */
class FragmentActivity : AppCompatActivity() {
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event?.action == KeyEvent.ACTION_UP) {
//            if (popupWindow != null && popupWindow?.isShowing == true) {
//                popupWindow?.dismiss()
//                return false
//            }
//        }
//        return super.onKeyDown(keyCode, event)
//    }

    override fun onBackPressed() {
        if (popupWindow != null && popupWindow?.isShowing == true) {
            popupWindow?.dismiss()
            return
        }
        super.onBackPressed()
    }
    private var popupWindow: PopupWindow? = null
    private lateinit var mTextView: TextView
    fun showPop() {
        popupWindow = PopupWindow(
            contentView4Pop(),
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        popupWindow?.showAtLocation(mTextView, 0, 0, 0)
    }
    private fun contentView() = UI {
        verticalLayout {
            mTextView = textView {
                text = "Fragment"
                textSize = 40F
                onClick {
                    //                    startActivity<com.yanftch.review.android.pages.TestActivity>()
                    showPop()
                }
            }
        }
    }.view

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("debug_FragmentActivity", "onCreate: ")
        setContentView(contentView())
//        setContentView(R.layout.activity_fragment)
//        supportFragmentManager.beginTransaction().replace(R.id.dynamic_fragment,
//            Fragment1()
//        ).commit()
    }

    override fun onStart() {
        super.onStart()
        Log.e("debug_FragmentActivity", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.e("debug_FragmentActivity", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e("debug_FragmentActivity", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e("debug_FragmentActivity", "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("debug_FragmentActivity", "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("debug_FragmentActivity", "onDestroy: ")
    }
}
