package com.yanftch.review.android.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yanftch.review.R;
import com.yanftch.review.android.modules.RowsBean;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @Description:
 * @Author: zhangyx
 * @CreateDate: 2020-06-17
 */
@SuppressLint("LongLogTag")
public class DetailPlayEvaluationAdapter extends RecyclerView.Adapter<DetailPlayEvaluationAdapter.ItemViewHolder> {
    private Context mContext;
    private List<RowsBean> mList;
    WeakReference<View> mVideoView;

    private int mScreenWidth;
    private int mScreenHeight;

    public DetailPlayEvaluationAdapter(Context context, List<RowsBean> list) {
        this.mContext = context;
        this.mList = list;
        mScreenWidth = mContext.getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = mContext.getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    public void onViewRecycled(@NonNull ItemViewHolder holder) {
        super.onViewRecycled(holder);
        if (holder.mImageView != null) {
            Log.e("debug_DetailPlayEvaluationAdapter:", "onViewRecycled==> " + "holder.hashCode() = " + holder.hashCode() + ", imageView.hashCode() = " + holder.mImageView.hashCode());
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ItemViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder.mImageView != null) {
            Log.e("debug_DetailPlayEvaluationAdapter:", "onViewDetachedFromWindow==> " + "holder.hashCode() = " + holder.hashCode() + ", imageView.hashCode() = " + holder.mImageView.hashCode());
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ItemViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        Log.e("debug_DetailPlayEvaluationAdapter:", "onViewAttachedToWindow==> " + "holder.hashCode() = " + holder.hashCode() + ", imageView.hashCode() = " + holder.mImageView.hashCode());

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_play_evaluation_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
//        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;

        RowsBean model = mList.get(position);
        if (model == null) {
            return;
        }

        Log.e("debug_DetailPlayEvaluationAdapter:", "onBindViewHolder==> position = " + position + ", holder.hashCode() = " + holder.hashCode() + ", imageView.hashCode() = " + holder.mImageView.hashCode());

        String picList = model.getPicList();
        Glide.with(mContext).load(picList).into(holder.mImageView);

        holder.mTvDebugInfo.setText(position + ", holder.hashCode = " + holder.hashCode() + ", imageView.hashCode = " + holder.mImageView.hashCode());
    }

    @Override
    public int getItemCount() {
        return null == mList ? 0 : mList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        private TextView mTvDebugInfo;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_image);
            mTvDebugInfo = itemView.findViewById(R.id.tv_debug_info);

        }
    }
}
