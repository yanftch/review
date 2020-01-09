package com.yanftch.review.android.pages

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.R
import kotlinx.android.synthetic.main.activity_animation.*
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.toast
import java.util.concurrent.Callable
import java.util.concurrent.atomic.AtomicInteger

class AnimationActivity : AppCompatActivity() {

    private lateinit var objectAnim: ObjectAnimator
    private var myThread: com.yanftch.review.android.pages.AnimationActivity.MyThread3? = null
    private val atomicInteger: AtomicInteger? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        EventBus.getDefault().register(this)
        objectAnim =
            ObjectAnimator.ofInt(progress_horizontal, "progress", 0, 100).setDuration(10000)

        objectAnim.addUpdateListener { animation ->
            Log.e("debug_AnimationActivity", "onAnimationUpdate: ${animation?.animatedValue}")
        }
        objectAnim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                toast("end")
                myThread?.call()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
                toast("start")
            }

        })
        btn_anim_start1.onClick {
            objectAnim.start()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)

    }


    class MyThread : Thread() {
        override fun run() {
            super.run()

        }
    }

    class MyThread2 : Runnable {
        override fun run() {
            Log.e("debug_MyThread2", "run: ")
        }

    }
    class MyThread3: Callable<Any>{
        override fun call(): Any? {

            return null
        }

    }
}
