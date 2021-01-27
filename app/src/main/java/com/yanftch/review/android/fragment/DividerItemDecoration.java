package com.yanftch.review.android.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;
import com.yanftch.review.android.utils.DensityUtil;

/**
 * Created by Wangm on 2018/9/14.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private int dividerHeight;
    private Paint dividerPaint;
    private Context mContext;

    public DividerItemDecoration(Context context) {
        mContext = context;
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(R.color.color_cL1_6));

        dividerHeight = DensityUtil.dip2px(context, 0.5f);
    }

    public DividerItemDecoration(Context context, float height) {
        mContext = context;
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(R.color.white));

        dividerHeight = DensityUtil.dip2px(context, height);
    }

    public void setDividerHeight(int dpHeight) {
        dividerHeight = DensityUtil.dip2px(mContext, dpHeight);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int top = view.getTop();
            int bottom = view.getBottom() + dividerHeight;

            c.drawRect(left, top, right, bottom, dividerPaint);
        }
    }
}
