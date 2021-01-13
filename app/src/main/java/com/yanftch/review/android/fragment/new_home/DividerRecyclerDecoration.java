package com.yanftch.review.android.fragment.new_home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;
import com.yanftch.review.android.utils.DensityUtil;
import com.yanftch.review.android.utils.ScreenUtils;


/**
 * Created by Wangm on 2018/5/24.
 */
public class DividerRecyclerDecoration extends RecyclerView.ItemDecoration{
    private int dividerHeight;
    private Paint dividerPaint;
    private boolean mIsLastDividerShow;
    private Context mContext;

    public DividerRecyclerDecoration(Context context) {
        mContext = context;
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(R.color.white));

        dividerHeight = ScreenUtils.dp2px(context,0.5f);
    }

    public DividerRecyclerDecoration( Context context, int dividerHeight, boolean isLastDividerShow) {
        mContext = context;
        this.dividerHeight = dividerHeight;
        mIsLastDividerShow = isLastDividerShow;
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(R.color.transparent));
    }

    public void setDividerWidth(int dpWidth) {
        dividerHeight = DensityUtil.dip2px(mContext,dpWidth);
    }

    public void setLastDividerShow(boolean lastDividerShow) {
        mIsLastDividerShow = lastDividerShow;
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

        int max = childCount;
        if (!mIsLastDividerShow) {
            max = childCount -1;
        }
        for(int i=0; i<max; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + dividerHeight;

            c.drawRect(left,top, right, bottom, dividerPaint);
        }
    }
}
