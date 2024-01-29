package com.yanftch.review.android.view;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * 用来辅助画圆角的类
 *
 * @author 宋疆疆
 * @since 2018/5/29.
 */
public class RoundDrawer {

    private float[] mRadiusArray = {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};

    public RoundDrawer(float leftTop, float rightTop, float rightBottom, float leftBottom) {
        mRadiusArray[0] = leftTop;
        mRadiusArray[1] = leftTop;
        mRadiusArray[2] = rightTop;
        mRadiusArray[3] = rightTop;
        mRadiusArray[4] = rightBottom;
        mRadiusArray[5] = rightBottom;
        mRadiusArray[6] = leftBottom;
        mRadiusArray[7] = leftBottom;
    }

    public void onDraw(Canvas canvas, int width, int height) {
        Path path = new Path();
        path.addRoundRect(new RectF(0, 0, width, height), mRadiusArray, Path.Direction.CW);
        canvas.clipPath(path);
    }
}
