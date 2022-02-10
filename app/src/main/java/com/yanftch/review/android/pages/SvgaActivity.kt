package com.yanftch.review.android.pages

import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.opensource.svgaplayer.SVGADrawable
import com.opensource.svgaplayer.SVGAImageView
import com.opensource.svgaplayer.SVGAParser
import com.opensource.svgaplayer.SVGAVideoEntity
import com.opensource.svgaplayer.utils.SVGARange
import com.yanftch.review.R
import org.jetbrains.anko.toast

class SvgaActivity : AppCompatActivity() {
    private lateinit var tvBabA: TextView
    private lateinit var tvBabB: TextView
    private lateinit var tvBabC: TextView
    private lateinit var tvBabD: TextView

    private lateinit var svagView: SVGAImageView
    private lateinit var parser: SVGAParser
    private lateinit var valueAnimator: ValueAnimator

    // 记录上次播放的是第几帧
    private val mLastSvgaFrame = 0
    private var mCurrentSvgaFrame = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_svga)
        tvBabA = findViewById(R.id.tv_tab_a)
        tvBabB = findViewById(R.id.tv_tab_b)
        tvBabC = findViewById(R.id.tv_tab_c)
        tvBabD = findViewById(R.id.tv_tab_d)
//        ABCD_SVGA.svga
        svagView = findViewById(R.id.sv_live)


        parser = SVGAParser(this)
        svagView.loops=1

        parser.decodeFromAssets("ABCD_SVGA.svga", object : SVGAParser.ParseCompletion {
            override fun onComplete(videoItem: SVGAVideoEntity) {
                val drawable = SVGADrawable(videoItem)
                svagView.setImageDrawable(drawable)
//                svagView.startAnimation()
            }

            override fun onError() {
                toast("加载出错了")
            }
        })
        tvBabA.setOnClickListener { changeTab(0) }
        tvBabB.setOnClickListener { changeTab(1) }
        tvBabC.setOnClickListener { changeTab(2) }
        tvBabD.setOnClickListener { changeTab(3) }
    }

    private fun changeTab(index: Int) {
//        if (valueAnimator != null) {
//            valueAnimator?.end();
//            valueAnimator = null;
//        }
//        var frame = when (index) {
//            0 -> {
//                29
//            }
//            1 -> {
//150
//            }
//            2 -> {
//271
//            }
//            3 -> {
//392
//            }
//        }
////		Log.e(TAG, "changeSvga: 开始  mLastSvgaFrame = " + mLastSvgaFrame + ", mCurrentSvgaFrame = " +
////		mCurrentSvgaFrame);
//
//        //		Log.e(TAG, "changeSvga: 开始  mLastSvgaFrame = " + mLastSvgaFrame + ", mCurrentSvgaFrame = " +
////		mCurrentSvgaFrame);
//        mCurrentSvgaFrame = frame
//        val length: Int = Math.abs(frame - mLastSvgaFrame) // 当前要执行的帧数
//
//        val duration = 392.0 / length
//        var valueDuration = 1000
//        if (1.0 <= duration && duration < 1.5) {
//            valueDuration = 3000
//        } else if (1.5 <= duration && duration < 3.0) {
//            valueDuration = 2000
//        }
////		Log.e(TAG, "changeSvga: duration = " + duration + ", valueDuration = " + valueDuration);
//
//        //		Log.e(TAG, "changeSvga: duration = " + duration + ", valueDuration = " + valueDuration);
//        valueAnimator = ValueAnimator.ofInt(mLastSvgaFrame, frame)
//        valueAnimator.setDuration(valueDuration.toLong())
//        valueAnimator.addUpdateListener(ValueAnimator.AnimatorUpdateListener { animation ->
//            val value = animation.animatedValue as Int
//            //				Log.e(TAG, "onAnimationUpdate: " + value);
//            mSvgaView.stepToFrame(value, false)
//        })
//
//        when (index) {
//            0 -> {
//                val range = SVGARange(0, 29)
//                svagView.startAnimation(range, false)
//                svagView
//            }
//            1 -> {
//
//            }
//            2 -> {
//
//            }
//            3 -> {
//
//            }
//        }
    }
}