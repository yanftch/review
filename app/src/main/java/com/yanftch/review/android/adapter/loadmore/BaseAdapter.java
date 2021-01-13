package com.yanftch.review.android.adapter.loadmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<M, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    protected final Context mContext;
    protected final LayoutInflater mInflater;
    protected final List<M> mList = new ArrayList<>();

    /**
     * 指定Adapter的viewType
     */
    private int mViewType = -1;

    public BaseAdapter(Context ctx) {
        mContext = ctx;
        mInflater = LayoutInflater.from(ctx);
    }

    /**
     * 允许为Adapter指定viewType，是的Adapter只展示指定类型
     */
    public void setData(List<M> list) {
        mList.clear();
        if (list != null) {
            mList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setViewType(int viewType) {
        mViewType = viewType;
    }

    public void addData(List<M> list) {
        int start = mList.size();
        if (list == null) {
            return;
        }

        if (mList.size() > 0) {
            mList.addAll(list);
            //防止已加载的item左右变动
            notifyItemRangeInserted(start, list.size());
        } else {
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void removeItem(int idx) {
        if (idx >= 0 && idx < mList.size()) {
            mList.remove(idx);
            notifyItemRemoved(idx);
        }
    }

    public void removeAll(int idx, List<M> removeList) {
        if (removeList == null || removeList.size() == 0 || idx < 0) {
            return;
        }
        boolean removeAll = mList.removeAll(removeList);
        if (removeAll) {
            notifyItemRangeRemoved(idx, removeList.size());
        }
    }

    public int indexOf(M m) {
        return mList.indexOf(m);
    }

    public boolean isEmpty() {
        return mList.size() == 0;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return inflateView(viewType, mInflater);
    }

    protected abstract VH inflateView(int viewType, LayoutInflater inflater);

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        M data = mList.get(position);
        if (data == null) {
            return;
        }
        holder.init(data, position);
        holder.bind(data, position);

        if (position + 1 < mList.size()) {
            M nextData = mList.get(position + 1);
            holder.bind(data, position, nextData);
        } else {
            holder.bind(data, position, null);
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mViewType != -1) {
            return mViewType;
        }
        M m = mList.get(position);
        if (m != null) {
            return getType(m);
        }
        return -1;
    }

    protected abstract int getType(@NonNull M m);


}
