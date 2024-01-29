package com.yanftch.review.android.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.yanftch.review.R

class DiySwitchView @kotlin.jvm.JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var tvLeft: TextView
    private var tvRight: TextView

    // 记录选中的
    private var selectedRight = true

    init {
        LayoutInflater.from(context).inflate(R.layout.zra_view_custom_switch_view, this, true)
        tvLeft = findViewById(R.id.tv_switch_left)
        tvRight = findViewById(R.id.tv_switch_right)

        initView()
    }

    private fun initView() {
        tvLeft.text = "户型"
        tvRight.text = "公寓"

//        setOnClickListener {
//            // 点击
//            selectedRight = !selectedRight
//            refreshView()
//            listener?.onChange(selectedRight)
//        }

        tvLeft.setOnClickListener {
            if (selectedRight) {
                selectedRight = !selectedRight
                refreshView()
                listener?.onChange(selectedRight)
            } else {
                return@setOnClickListener
            }
        }

        tvRight.setOnClickListener {
            if (selectedRight) {
                return@setOnClickListener
            } else {
                selectedRight = !selectedRight
                refreshView()
                listener?.onChange(selectedRight)
            }
        }
    }

    /**
     * 更新选中状态
     */
    fun updateSelected(selectedRight: Boolean) {
        this.selectedRight = selectedRight
        refreshView()
    }

    private fun refreshView() {
        if (selectedRight) {
            tvRight.setTextColor(ContextCompat.getColor(context, R.color.color_ct1_85))
            tvLeft.setTextColor(ContextCompat.getColor(context, R.color.color_ct1_60))

            tvRight.setBackgroundResource(R.drawable.zra_bg_white_radius_40dp)
            tvLeft.setBackgroundResource(R.drawable.zra_bg_trans)

        } else {
            tvRight.setTextColor(ContextCompat.getColor(context, R.color.color_ct1_60))
            tvLeft.setTextColor(ContextCompat.getColor(context, R.color.color_ct1_85))

            tvRight.setBackgroundResource(R.drawable.zra_bg_trans)
            tvLeft.setBackgroundResource(R.drawable.zra_bg_white_radius_40dp)
        }
    }

    interface OnChangeListener {
        fun onChange(selectedRight: Boolean)
    }

    private var listener: OnChangeListener? = null
    fun setOnChangeListener(l: OnChangeListener) {
        listener = l
    }

}