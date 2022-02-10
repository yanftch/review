package com.yanftch.review.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.yanftch.review.R;

public class TextViewLine extends androidx.appcompat.widget.AppCompatTextView {
    private static final String TAG = "debug_TextViewLine";

    public TextViewLine(Context context) {
        super(context);
        init(context);
    }

    public TextViewLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextViewLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
mContext = context;

    }

    private Context mContext;
    private Rect mRect = new Rect();
    private Paint mPaint = new Paint();
    private Paint mLinePaint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        CharSequence text = getText();

        mLinePaint.setColor(ContextCompat.getColor(mContext, R.color.color_c4_10));

        mPaint.getTextBounds(text.toString(), 0, text.length(), mRect);
        int w = mRect.left + mRect.right;
        float x = getX();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        Log.e(TAG, "onDraw: text = " + text + ", w = " + w + " x = " + x
                + ",measuredHeight="+measuredHeight
                + ", measuredWidth = " +measuredWidth

        );

        canvas.drawRect(x, measuredHeight-12, measuredWidth, measuredHeight+60, mLinePaint);


    }
}
