package com.yanftch.review.android.view

import android.content.Context
import android.graphics.Canvas
import android.view.View

/**
 *
 * User : yanftch
 * Date : 2019-08-07
 * Time : 10:51
 * Desc :
 */
class DiyView : View {
    constructor(context: Context) : super(context)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }


}