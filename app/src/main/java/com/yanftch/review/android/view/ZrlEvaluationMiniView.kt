package com.yanftch.review.android.view

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.yanftch.review.R

/**
 * User : yanftch
 * Date : 2020-04-09
 * Time : 09:27
 * Desc : 详情页组件-顶部小 评价 入口UI组件
 */
class ZrlEvaluationMiniView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private var mContext: Context = context
    private var mTvScore: TextView

    /**
     * 项目ID 和 房型ID 注入
     */
    private var mProjectId: String? = null
    private var mHouseTypeId: String? = null

    /**
     * 在哪个页面被加载
     */
    private var mViewHeight = 0
    private var mWidth: Int = 0
    private var mHeight: Int = 0
    private var mTopView: View


    init {
        LayoutInflater.from(mContext)
            .inflate(R.layout.zra_zrl_include_detail_mini_evaluations, this)
        mTvScore = findViewById(R.id.tv_evaluation_score_count)
        mTopView = findViewById(R.id.v_top)
    }

    fun inject(projectId: String?, houseTypeId: String?) {
        mProjectId = projectId
        mHouseTypeId = houseTypeId
    }

    fun setData(model: String) {
        visibility = View.INVISIBLE
        mTvScore.text = model
        // 添加显示动画
//        getTotalHeight()
        visibility = View.VISIBLE


        post {
            mWidth = measuredWidth
            mHeight = measuredHeight
        }


    }

    /**
     * 获取view的高度
     */
    private fun getTotalHeight() {
        post {
            if (mViewHeight <= 0) {
                mViewHeight = measuredHeight
            }
            Log.e("debug_ZrlEvaluationMiniView:", "getTotalHeight==> mViewHeight = " + mViewHeight)
            animateToShow()
        }
    }

    private fun animateToShow() {
        val valueAnimator = ValueAnimator.ofFloat(0f, mViewHeight.toFloat())
        valueAnimator.duration = 3000
        valueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float
            setViewHeight(value.toInt())
        }
        valueAnimator.start()
        visibility = View.VISIBLE
    }

    private fun setViewHeight(height: Int) {
        val layoutParams = layoutParams
        layoutParams.height = height
        requestLayout()
    }

}