package com.yanftch.review.android.utils

import android.content.Context
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.yanftch.review.R

/**
 * User : yanftch
 * Date : 2020-04-16
 * Time : 10:35
 * Desc : 添加标签的统一工具类
 */
object AddTagUtils {

    /**
     * 给一个 ViewGroup 内部添加标签
     * @param context Context
     * @param container 外层容器
     * @param title 标签文案
     * @param textColor 标签颜色
     * @param backgroundRes 背景drawable
     * @param textSize 字体大小(sp值)
     * @param leftPadding 文案左右 padding
     * @param topPadding 文案上下 padding
     * @param rightMargin 右边距
     * @param topMargin 上边距
     * @param onClick 点击回调
     */
    @JvmOverloads
    fun addTag(context: Context?, container: ViewGroup?, title: String?, @ColorRes textColor: Int = R.color.black_500, @DrawableRes backgroundRes: Int = R.drawable.bg_shape_outer_24, textSize: Float = 12f, leftPadding: Float = 6f, topPadding: Float = 4f, rightMargin: Float = 10f, topMargin: Float? = 0f, onClick: (() -> Void?)? = null) {
        val textView = TextView(context)
        textView.text = title
        textView.setTextColor(ContextCompat.getColor(context!!, textColor))
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
        textView.includeFontPadding = false
        textView.gravity = Gravity.CENTER
        textView.setPadding(ScreenUtils.dp2px(context, leftPadding), ScreenUtils.dp2px(context, topPadding), ScreenUtils.dp2px(context, leftPadding), ScreenUtils.dp2px(context, topPadding))
        textView.setBackgroundResource(backgroundRes)
        textView.setOnClickListener { onClick?.invoke() }
        val layoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(0, ScreenUtils.dp2px(context, topMargin
                ?: 0f), ScreenUtils.dp2px(context, rightMargin), 0)
        textView.layoutParams = layoutParams
        container?.addView(textView)
    }

    @JvmOverloads
    fun addTag2(context: Context?, container: ViewGroup?, title: String?, @ColorRes textColor: Int = R.color.black_500, @DrawableRes backgroundRes: Int = R.drawable.bg_shape_outer_24, textSize: Float = 12f, leftPadding: Float = 6f, topPadding: Float = 4f, rightMargin: Float = 10f, topMargin: Float? = 0f,
                onClick: (() -> Unit?)) {
        val textView = TextView(context)
        textView.text = title
        textView.setTextColor(ContextCompat.getColor(context!!, textColor))
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
        textView.includeFontPadding = false
        textView.gravity = Gravity.CENTER
        textView.setPadding(ScreenUtils.dp2px(context, leftPadding), ScreenUtils.dp2px(context, topPadding), ScreenUtils.dp2px(context, leftPadding), ScreenUtils.dp2px(context, topPadding))
        textView.setBackgroundResource(backgroundRes)
        textView.setOnClickListener { onClick.invoke() }
        val layoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(0, ScreenUtils.dp2px(context, topMargin
            ?: 0f), ScreenUtils.dp2px(context, rightMargin), 0)
        textView.layoutParams = layoutParams
        container?.addView(textView)
    }
}