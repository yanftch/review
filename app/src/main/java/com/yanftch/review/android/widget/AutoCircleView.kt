package com.yanftch.review.android.widget

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.yanftch.review.R
import com.yanftch.review.android.utils.getEventName

/**
 * 自定义View，按下缩小抬起手指恢复原状
 */
class AutoCircleView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attributeSet, defStyleAttr) {
    private val TAG = "debug_AutoCircleView"

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.color_8E7047))
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return true
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e(TAG, "dispatchTouchEvent: " + ev.getEventName())
        when (ev?.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                downEvent()
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                upEvent()
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    /**
     * 按下缩小
     */
    private fun downEvent() {
        Log.e(TAG, "downEvent: ")
        val set = AnimatorSet()
        set.playTogether(
            ObjectAnimator.ofFloat(this@AutoCircleView, "scaleX", 1f, 0.9f),
            ObjectAnimator.ofFloat(this@AutoCircleView, "scaleY", 1f, 0.9f),
            ObjectAnimator.ofFloat(this@AutoCircleView, "alpha", 1f, 0.9f)
        )
        set.setDuration(100).start()
    }

    /**
     * 抬起恢复
     */
    private fun upEvent() {
        Log.e(TAG, "upEvent: ")
        val set = AnimatorSet()
        set.playTogether(
            ObjectAnimator.ofFloat(this@AutoCircleView, "scaleX", 0.9f, 1f),
            ObjectAnimator.ofFloat(this@AutoCircleView, "scaleY", 0.9f, 1f),
            ObjectAnimator.ofFloat(this@AutoCircleView, "alpha", 0.9f, 1f)
        )
        set.setDuration(100).start()
    }


}
