package com.yanftch.review.android.adapter.loadmore;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<M> extends RecyclerView.ViewHolder {
    private M mBean;
    protected float mDensity;
    protected int mScreenWidth;
    protected int mPosition;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void init(M m, int position) {
        this.mBean = m;
        this.mPosition = position;
    }

    public abstract void bind(@NonNull M data, int position);

    public void bind(@NonNull M data, int position, @Nullable M nextData) {
    }

    protected M getData() {
        return mBean;
    }

    public int getLocation() {
        return mPosition;
    }

    public void setDensity(float density, int screenWidth) {
        mDensity = density;
        mScreenWidth = screenWidth;
    }

    protected boolean isFullSpan() {
        return false;
    }
}
