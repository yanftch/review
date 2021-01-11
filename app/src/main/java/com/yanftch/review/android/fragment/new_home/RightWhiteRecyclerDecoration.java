package com.yanftch.review.android.fragment.new_home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;
import com.yanftch.review.android.utils.DensityUtil;

/**
 * Created by Wangm on 2018/5/24.
 */
public class RightWhiteRecyclerDecoration extends RecyclerView.ItemDecoration{
    private int dividerWidth;
    private Paint dividerPaint;
    private Context mContext;

    public RightWhiteRecyclerDecoration(Context context) {
        mContext = context;
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(R.color.white));

        dividerWidth = DensityUtil.dip2px(context,10);
    }

    public void setDividerWidth(int dpWidth) {
        dividerWidth = DensityUtil.dip2px(mContext,dpWidth);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = dividerWidth;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();

        for(int i=0; i<childCount; i++) {
            View view = parent.getChildAt(i);
            float left = view.getRight();
            float right = view.getRight() + dividerWidth;

            c.drawRect(left,top, right, bottom, dividerPaint);
        }
    }
}
