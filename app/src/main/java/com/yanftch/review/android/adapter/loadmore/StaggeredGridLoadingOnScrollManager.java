package com.yanftch.review.android.adapter.loadmore;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public abstract class StaggeredGridLoadingOnScrollManager extends RecyclerView.OnScrollListener implements LoadMoreAdapter.LoadMoreListener {

    private StaggeredGridLayoutManager mLayoutManager;

    private final int[] mLastVisiblePosition;
    private boolean mEnableLoadMore = true;
    private int mLimitPositions;
    private final int mLimitDy;

    private int mDy;


    public StaggeredGridLoadingOnScrollManager(StaggeredGridLayoutManager layoutManager, int limitDy) {
        this.mLayoutManager = layoutManager;
        int spanCount = layoutManager.getSpanCount();
        mLastVisiblePosition = new int[spanCount];

        mLimitDy = limitDy;
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter!=null){
                mLimitPositions = adapter.getItemCount() - 2;
            }
            mDy = 0;
            return;
        }
        if (!mEnableLoadMore) {
            return;
        }
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            int[] lastVisibleItemPositions = mLayoutManager.findLastVisibleItemPositions(mLastVisiblePosition);
            if (lastVisibleItemPositions[0] >= mLimitPositions || lastVisibleItemPositions[1] >= mLimitPositions) {
                disableLoadMoreOnScroll();
                recyclerView.post(loadMoreRunnable);
            }
        }
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (!mEnableLoadMore) {
            return;
        }
        if (dy < 0) {
            return;
        }
        mDy += dy;

        if (mDy >= mLimitDy) {
            mDy = 0;
            int[] lastVisibleItemPositions = mLayoutManager.findLastVisibleItemPositions(mLastVisiblePosition);
            if (lastVisibleItemPositions[0] >= mLimitPositions || lastVisibleItemPositions[1] >= mLimitPositions) {
                disableLoadMoreOnScroll();
                recyclerView.post(loadMoreRunnable);
            }
        }
    }

    private Runnable loadMoreRunnable = () -> onLoadMore();

    public void enableLoadMoreOnScroll() {
        mEnableLoadMore = true;
    }
    public void disableLoadMoreOnScroll() {
        mEnableLoadMore = false;
    }


}