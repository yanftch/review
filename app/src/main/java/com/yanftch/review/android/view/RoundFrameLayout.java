package com.yanftch.review.android.view;

import android.content.Context;
import android.graphics.Canvas;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;


/**
 * Created by huangjin.
 * Date: 2019-08-26 3:32 PM
 * Description:
 */
public class RoundFrameLayout extends FrameLayout {

    private RoundDrawer mRoundDrawer;

    public RoundFrameLayout(@NonNull Context context) {
        super(context);
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setRadius(float leftTop, float rightTop, float rightBottom, float leftBottom) {
        mRoundDrawer = new RoundDrawer(leftTop, rightTop, rightBottom, leftBottom);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mRoundDrawer != null) {
            mRoundDrawer.onDraw(canvas, getWidth(), getHeight());
        }
        super.onDraw(canvas);
    }



}
