package com.yanftch.review.android.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.yanftch.review.R
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textColorResource
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout


/**
 *
 * User : yanftch
 * Date : 2019-10-30
 * Time : 19:50
 * Desc :
 */
class Fragment1 : Fragment() {
    private lateinit var mTextView: TextView
    private var popupWindow: PopupWindow? = null

    init {

        /**
         * Control whether a fragment instance is retained across Activity
         * re-creation (such as from a configuration change).  This can only
         * be used with fragments not in the back stack.  If set, the fragment
         * lifecycle will be slightly different when an activity is recreated:
         * <ul>
         * <li> {@link #onDestroy()} will not be called (but {@link #onDetach()} still
         * will be, because the fragment is being detached from its current activity).
         * <li> {@link #onCreate(Bundle)} will not be called since the fragment
         * is not being re-created.
         * <li> {@link #onAttach(Activity)} and {@link #onActivityCreated(Bundle)} <b>will</b>
         * still be called.
         * </ul>
         */
        retainInstance = false // 默认值是 FALSE

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("debug_Fragment1", "onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("debug_Fragment1", "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("debug_Fragment1", "onCreateView: ")
        return contentView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("debug_Fragment1", "onActivityCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.e("debug_Fragment1", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.e("debug_Fragment1", "onResume: ")
        view?.isFocusableInTouchMode = true
        view?.requestFocus()
        view?.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                if (popupWindow != null && popupWindow!!.isShowing) {
                    popupWindow!!.dismiss()
                    return@OnKeyListener true //当fragment消费了点击事件后，返回true，activity中的点击事件就不会执行了
                }
            }
            false //当fragmenet没有消费点击事件，返回false，activity中继续执行对应的逻辑
        })
    }

    override fun onPause() {
        super.onPause()
        Log.e("debug_Fragment1", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e("debug_Fragment1", "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("debug_Fragment1", "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("debug_Fragment1", "onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("debug_Fragment1", "onDetach: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("debug_Fragment1", "onSaveInstanceState: ")
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


    fun showPop() {
        popupWindow = PopupWindow(
            contentView4Pop(),
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        popupWindow?.showAtLocation(mTextView, 0, 0, 0)
    }
}