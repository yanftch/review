package com.yanftch.review.android.adapter.loadmore;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.yanftch.review.R;

import java.util.ArrayList;
import java.util.List;

public abstract class LoadMoreAdapter<M extends LoadMoreAdapter.IMuilType, VH extends BaseViewHolder> extends BaseAdapter<M, VH> {

    //loadmore
    private final int VIEW_TYPE_LOAD_MORE = Integer.MAX_VALUE;

    private final LoadMoreBean LOAD_MORE = new LoadMoreBean();

    private StaggeredGridLayoutManager mLayoutManager;
    private LoadMoreListener mListener;
    private StaggeredGridLoadingOnScrollManager mLoadingOnScrollManager;


    public LoadMoreAdapter(Context ctx, int tab) {
        super(ctx);
        LOAD_MORE.setTab(tab);
    }

    @Override
    protected int getType(M m) {
        return m.getViewType();
    }

    @Override
    protected VH inflateView(int viewType, LayoutInflater inflater) {
        if (viewType == VIEW_TYPE_LOAD_MORE) {
            return (VH) new LoadMoreViewHolder(inflater.inflate(R.layout.zra_item_feed_load_more, null));
        }
        return null;
    }

    @Override
    public void setData(List<M> list) {
        //请使用setData(List<M> list, int status)
    }

    public void setData(List<M> list, int status) {
        if (list != null) {
            LOAD_MORE.setStatus(status);
            list.add((M) LOAD_MORE);
        }
        super.setData(list);

        if (status == LoadMoreBean.NORMAL) {
            enableLoadMoreOnScroll();
        }else {
            disableLoadMoreOnScroll();
        }
    }

    public void setData2(List<M> list, int status) {
        ArrayList<M> result = new ArrayList<>();
        if (list != null) {
            LOAD_MORE.setStatus(status);
            result.addAll(list);
            result.add((M) LOAD_MORE);
        }
        super.setData(result);

        if (status == LoadMoreBean.NORMAL) {
            enableLoadMoreOnScroll();
        }else {
            disableLoadMoreOnScroll();
        }
    }

    @Override
    public void addData(List<M> list) {
        //请使用addData(List<M> list, int status)
    }

    public void addData(List<M> list, int status) {
        if (list == null) {
            return;
        }

        LOAD_MORE.setStatus(status);
        list.add((M) LOAD_MORE);

        int i = mList.lastIndexOf(LOAD_MORE);
        int start = mList.size();
        int insertCount = list.size();

        if (i >= 0) {
            mList.remove(i);

            mList.addAll(list);
            //防止已加载的item左右变动
            notifyItemRangeInserted(start - 1, insertCount);
        } else {
            mList.addAll(list);
            notifyItemRangeInserted(start, insertCount);
        }

        if (status == LoadMoreBean.NORMAL) {
            enableLoadMoreOnScroll();
        }else {
            disableLoadMoreOnScroll();
        }
    }

    public void setLoadMoreListener(LoadMoreListener listener) {
        mListener = listener;
    }

    public boolean varifyLoadMoreEvent(LoadMoreBean bean) {
        return LOAD_MORE == bean;
    }

    public void showLoading() {
        LOAD_MORE.setStatus(LoadMoreBean.NORMAL);
        int idx = getItemCount() - 1;
        if (idx >= 0) {
            notifyItemChanged(idx);
        }

        disableLoadMoreOnScroll();
    }

    private void disableLoadMoreOnScroll() {
        if (mLoadingOnScrollManager != null) {
            mLoadingOnScrollManager.disableLoadMoreOnScroll();
        }
    }

    private void enableLoadMoreOnScroll() {
        if (mLoadingOnScrollManager != null) {
            mLoadingOnScrollManager.enableLoadMoreOnScroll();
        }
    }


    protected boolean isFooter(int itemViewType) {
        return itemViewType != VIEW_TYPE_LOAD_MORE;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull VH holder) {
        super.onViewAttachedToWindow(holder);
        if (holder.isFullSpan()) {
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp instanceof StaggeredGridLayoutManager.LayoutParams) {
                StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
                p.setFullSpan(true);
            }
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull VH holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof LoadMoreViewHolder) {
            ((LoadMoreViewHolder) holder).cancelAnimator();
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            mLayoutManager = ((StaggeredGridLayoutManager) layoutManager);

            DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            float density = displayMetrics.density;

            if (mLoadingOnScrollManager != null) {
                recyclerView.removeOnScrollListener(mLoadingOnScrollManager);
            }
            mLoadingOnScrollManager = new StaggeredGridLoadingOnScrollManager(mLayoutManager, (int) (density * 230)) {
                @Override
                public void onLoadMore() {
                    if (mListener != null) {
                        mListener.onLoadMore();
                    }
                }
            };
            recyclerView.addOnScrollListener(mLoadingOnScrollManager);
        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mLayoutManager = null;
    }


    public interface LoadMoreListener {
        void onLoadMore();
    }

    public interface IMuilType {
        int getViewType();
    }

    public interface IMuilTypeStable {
        // 好服务页面，底部管家说瀑布流类型
        final int KEEPERTALKSVIEWTYPE = 100;
        // 好玩，评论瀑布流类型
        final int DETAIL_PLAY_COMMENT_TYPE = 200;
    }

    public class LoadMoreBean implements LoadMoreAdapter.IMuilType {

        //分页数据的状态-没有更多了
        public static final int NO_MORE = 0;
        //分页数据的状态-出错
        public static final int ERROR = -1;
        //分页数据的状态-正常加载
        public static final int NORMAL = 1;

        private int status;
        private int tab;

        public int getStatus() {
            return status;
        }

        private void setStatus(int status) {
            this.status = status;
        }

        public int getTab() {
            return tab;
        }

        private void setTab(int tab) {
            this.tab = tab;
        }

        @Override
        public int getViewType() {
            return VIEW_TYPE_LOAD_MORE;
        }
    }
}
