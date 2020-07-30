package com.yanftch.review.android.view;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * 适用于瀑布流条目为2的RecyclerView
 */
public class ZraFeedDividerItemDecoration extends RecyclerView.ItemDecoration {

    private final int mDp4_5;
    private final int mDp10;

    public ZraFeedDividerItemDecoration(float density) {
        mDp4_5 = (int) (density * 4.5);
        mDp10 = (int) (density * 10);
    }

    /**
     * @param outRect 用于规定分割线的范围
     * @param view    进行分割线操作的子view
     * @param parent  父view
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        RecyclerView.Adapter adapter = parent.getAdapter();
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();

        if (adapter == null || layoutManager == null) {
            return;
        }
        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        boolean fullSpan = params.isFullSpan();
        if (fullSpan) {
            return;
        }

        outRect.left = mDp4_5;
        outRect.right = mDp4_5;
        outRect.top = mDp10;
    }

}