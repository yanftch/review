package com.yanftch.review.android.adapter.loadmore;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.yanftch.review.R;

import static android.animation.ValueAnimator.INFINITE;


public class LoadMoreViewHolder extends BaseViewHolder<LoadMoreAdapter.LoadMoreBean> implements View.OnClickListener {

    private final TextView mTv;
    private final ImageView mIv;
    private final ObjectAnimator mAnimator;

    public LoadMoreViewHolder(@NonNull View itemView) {
        super(itemView);
        mTv = itemView.findViewById(R.id.tv);
        mIv = itemView.findViewById(R.id.iv);

        mAnimator = ObjectAnimator.ofFloat(mIv, "rotation", 0f, -359f)
                .setDuration(800);

        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setRepeatCount(INFINITE);

        itemView.setOnClickListener(this);
    }

    @Override
    public void bind(@NonNull LoadMoreAdapter.LoadMoreBean data, int position) {
        int status = data.getStatus();

        if (status == LoadMoreAdapter.LoadMoreBean.NORMAL) {
            mTv.setText("正在加载更多的数据…");
            mIv.setVisibility(View.VISIBLE);

            mAnimator.start();
        } else if (status == LoadMoreAdapter.LoadMoreBean.NO_MORE) {
            mTv.setText(" - 我是有底线的 - ");
            mIv.setVisibility(View.GONE);
            cancelAnimator();
        } else if (status == LoadMoreAdapter.LoadMoreBean.ERROR) {
            mTv.setText("服务器加载异常，请稍后再试");
            mIv.setVisibility(View.GONE);
            cancelAnimator();
        }
    }

    public void cancelAnimator() {
        if (mAnimator.isRunning()) {
            mAnimator.cancel();
        }
    }

    @Override
    public void onClick(View v) {
//        LoadMoreAdapter.LoadMoreBean data = getData();
//        if (data != null && data.getStatus() == LoadMoreAdapter.LoadMoreBean.ERROR) {
//            EventBus.getDefault().post(data);
//        }
    }

    @Override
    protected boolean isFullSpan() {
        return true;
    }
}
