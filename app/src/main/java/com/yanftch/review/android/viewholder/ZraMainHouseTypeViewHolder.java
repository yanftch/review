package com.yanftch.review.android.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanftch.review.R;
import com.yanftch.review.android.fragment.new_home.model.ZraRecFlowBean;

/**
 * User : yanftch
 * Date : 2021/1/13
 * Time : 16:42
 * Desc : 首页-房型卡片
 */
public class ZraMainHouseTypeViewHolder extends BaseCardViewHolder {

    private SimpleDraweeView mPvMainImg;
    //    private PictureView mPvMainImg;
    // 左上角标签
    private TextView mTvTime;
    private TextView mTvAddress;

    // 房型名
    private TextView mTvTitle;
    private TextView mTvSubtitle;
    // 价格(优惠价)
    private TextView mTvPrice;
    // 划线价
    private TextView mTvOriginalPrice;
    private TextView mTvPriceUnit;
    private TextView mTvPricePrefix;


    public ZraMainHouseTypeViewHolder(@NonNull View itemView, @NonNull Context ctx) {
        super(itemView, ctx);
        mPvMainImg = itemView.findViewById(R.id.pv_main_img);
        mTvTime = itemView.findViewById(R.id.tv_time);
        mTvTitle = itemView.findViewById(R.id.tv_title);
        mTvSubtitle = itemView.findViewById(R.id.tv_sub_title);
        mTvPrice = itemView.findViewById(R.id.tv_price);
        mTvOriginalPrice = itemView.findViewById(R.id.tv_original_price);
        mTvPriceUnit = itemView.findViewById(R.id.tv_price_unit);
        mTvPricePrefix = itemView.findViewById(R.id.tv_price_prefix);
        mTvAddress = itemView.findViewById(R.id.tv_address);
    }

    @Override
    public void bind(@NonNull ZraRecFlowBean data, int position) {
        super.bind(data, position);

        // 展示主图
        displayMainImg(mPvMainImg, data);

        // 左上角标签(单个)  隐藏
        mTvTime.setVisibility(View.GONE);

        // 压图

        // 房型title
        // TODO:yanfeng 2021/1/14 换行，怎么显示左边的icon？？？

        mTvTitle.setText(data.getHouseTypeName());
        mTvSubtitle.setText(data.getHouseTypeName());
        mTvAddress.setText(data.getHouseTypeName());

        // 价格&划线价
        mTvPrice.setText(data.getPrice());
        mTvPriceUnit.setText(data.getPrice_unit());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
    }

    @Override
    protected float getMainImgRatio() {
        return 1.33f;
    }

}
