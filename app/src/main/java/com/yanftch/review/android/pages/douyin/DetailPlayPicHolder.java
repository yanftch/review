package com.yanftch.review.android.pages.douyin;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.yanftch.review.R;
import com.yanftch.review.android.modules.RowsBean;

public class DetailPlayPicHolder implements Holder<RowsBean.PicBean> {
    private View mView;
    private ImageView mPvPlayPic;
    private Context mContext;
    private int mScreenWidth;

    @Override
    public View createView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mView = inflater.inflate(R.layout.item_detail_play_pic, null);
        mPvPlayPic = mView.findViewById(R.id.pv_play_pic);
        mContext = mView.getContext();
        mScreenWidth = mContext.getResources().getDisplayMetrics().widthPixels;
        return mView;
    }

    @Override
    public void UpdateUI(Context context, int position, RowsBean.PicBean data) {
        if (data != null && !TextUtils.isEmpty(data.getPicUrl())) {
            ViewGroup.LayoutParams lp = mPvPlayPic.getLayoutParams();
            lp.width = mScreenWidth;
            if (data.getWidth() > 0) {
                lp.height = (int) (mScreenWidth * (data.getHeight() / data.getWidth()));
            } else {
                lp.height = (int) (mScreenWidth * 1.3);
            }
//            LogUtil.e("debug_DetailPlayPicHolder:", "UpdateUI==> " + "width === " + data.getHeight() + ", height = ===" + data.getWidth());
            Glide.with(context).load(data.getPicUrl()).into(mPvPlayPic);
            mPvPlayPic.setLayoutParams(lp);
        }
    }
}
