package com.yanftch.review.android.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;

import com.opensource.svgaplayer.SVGAParser;
import com.yanftch.review.R;
import com.yanftch.review.android.adapter.loadmore.BaseViewHolder;
import com.yanftch.review.android.adapter.loadmore.LoadMoreAdapter;
import com.yanftch.review.android.viewholder.ZraMainHouseTypeViewHolder;

/**
 * User : yanftch
 * Date : 2021/1/13
 * Time : 16:36
 * Desc : 自如寓首页底部瀑布流 adapter
 */

public class ZraRecFlowAdapter <M extends LoadMoreAdapter.IMuilType, VH extends BaseViewHolder<M>> extends LoadMoreAdapter<M, BaseViewHolder<M>> {
    protected final float mDensity;
    protected int mScreenWidth;
    private int mTab;

    private SVGAParser mParser;

    public ZraRecFlowAdapter(Context ctx, int tab) {
        super(ctx, tab);

        mTab = tab;

        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        mDensity = displayMetrics.density;
        mScreenWidth = displayMetrics.widthPixels;

        mParser = new SVGAParser(mContext);
    }

    @Override
    protected VH inflateView(int viewType, LayoutInflater inflater) {
        BaseViewHolder viewHolder = super.inflateView(viewType, inflater);
        switch (viewType) {
            case 1:
                viewHolder = new ZraMainHouseTypeViewHolder(inflater.inflate(R.layout.zra_main_item_rec_house_type, null), mContext);
            case 2:
            default:
                viewHolder = new ZraMainHouseTypeViewHolder(inflater.inflate(R.layout.zra_main_item_rec_house_type, null), mContext);
                break;
        }
        if (viewHolder != null) {
            viewHolder.setDensity(mDensity, mScreenWidth);
        }
        return (VH)viewHolder;
    }


}
