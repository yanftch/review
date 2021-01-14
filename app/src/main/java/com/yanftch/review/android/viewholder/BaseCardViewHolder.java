package com.yanftch.review.android.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanftch.review.android.adapter.loadmore.BaseViewHolder;
import com.yanftch.review.android.fragment.new_home.model.BaseImg;
import com.yanftch.review.android.fragment.new_home.model.ZraRecFlowBean;

import java.util.List;



/**
 * 主图：pv_main_img
 * 左上角标签：tv_time
 * 标题行：tv_title
 * 副标题行：tv_sub_title
 * 价格符号：tv_price_prefix
 * 价格：tv_price
 * 价格单位：tv_price_unit
 * 原价：tv_original_price
 * 地址：tv_address
 *
 */
public abstract class BaseCardViewHolder extends BaseViewHolder<ZraRecFlowBean> implements View.OnClickListener {

    protected final Context mContext;
    protected int mMainImgWidth;


    public BaseCardViewHolder(@NonNull View itemView, @NonNull Context ctx) {
        super(itemView);
        this.mContext = ctx;

        itemView.setOnClickListener(this);
    }

    @Override
    public void setDensity(float density, int screenWidth) {
        super.setDensity(density, screenWidth);
        mMainImgWidth = (int) (screenWidth / 375f * 163);
    }

    @Override
    public void onClick(View v) {
        if (v == itemView) {
            ZraRecFlowBean data = getData();
            if (data == null) {
                return;
            }
//            CardClickable.onCardClick(data, mContext);
            Toast.makeText(mContext, "card click " + data.getHouseTypeName(), Toast.LENGTH_SHORT).show();

            int position = -1;
            if (isHorizontalCard()) {
                position = getLocation();
            }
            track(data, "homePageCardClick", position, false, null);
        }
    }

    /**
     * @param data         数据
     * @param eventName    事件名
     * @param position     位置
     * @param isExposure   是否为曝光事件
     * @param exposureView 如果是曝光事件，则设置曝光的控件
     */
    private void track(ZraRecFlowBean data, String eventName, int position, boolean isExposure, View exposureView) {
//        mEvent.clear();
//
//        mEvent.setData(data);
//        mEvent.setExposure(isExposure);
//        mEvent.setExposureView(exposureView);
//        if (isHorizontalCard()) {
//            mEvent.setLocationId(position + 1);
//        }
//        mEvent.setEventName(eventName);
//        EventBus.getDefault().post(mEvent);
    }

    /**
     * 主位多媒体（图片，视频）
     * pv需要指定宽高
     */
    protected void displayMainMedia(SimpleDraweeView pv, TextView tvTime, ZraRecFlowBean bean) {
        if (pv == null || bean == null) {
            return;
        }

        String videoUrl = bean.getVideoUrl();
        boolean isVideo = !TextUtils.isEmpty(videoUrl);

        if (tvTime != null) {
            String videoDuration = bean.getVideoDuration();
            if (isVideo && !TextUtils.isEmpty(videoDuration)) {
                tvTime.setText(videoDuration);
                tvTime.setPadding(0, 0, (int) (mDensity * 6 + 0.5f), 0);
                tvTime.setVisibility(View.VISIBLE);
            }
//            else if (bean.hasVideo()) {
//                tvTime.setText("");
//                tvTime.setPadding(0, 0, (int) (mDensity * 2 + 0.5f), 0);
//                tvTime.setVisibility(View.VISIBLE);
//            }
            else {
                tvTime.setVisibility(View.GONE);
            }
        }

        //展示图片及视频
        displayMainImg(pv, bean);
    }

    /**
     * 主位图片，pv需要指定宽高
     */
    protected void displayMainImg(SimpleDraweeView pv, ZraRecFlowBean bean) {
        if (bean == null || pv == null) {
            return;
        }
        List<BaseImg> baseImg = bean.getBaseImg();
        if (baseImg != null && !baseImg.isEmpty()) {
            String imgUrl = baseImg.get(0).getImg();
            float ratio = baseImg.get(0).getRadio();
            int height = getMainImgHeight(ratio);
            if (!isMainImgfixedSize()) {
                //修改高度
                ViewGroup.LayoutParams layoutParams = pv.getLayoutParams();
                layoutParams.height = height;
            }

            pv.setImageURI(imgUrl);
            // TODO:yanfeng 2021/1/13 放开下边
//            pv.setController(ImageUtil.frescoResizeController(pic, mMainImgWidth, height));

        }
    }


    private int getMainImgHeight(float ratio) {
        if (ratio != 0) {
            return (int) (mMainImgWidth / ratio);
        }

        //UI图上给的宽高比
        float defaultRatio = getMainImgRatio();
        if (defaultRatio != 0) {
            return (int) (mMainImgWidth / defaultRatio);
        }

        return mMainImgWidth;
    }

    /**
     * 主位图片 宽比高
     */
    protected abstract float getMainImgRatio();

    /**
     * 主图片是否固定宽高
     */
    protected boolean isMainImgfixedSize() {
        return false;
    }

    /**
     * 是否横滑卡片
     */
    protected boolean isHorizontalCard() {
        return false;
    }


    /**
     * 展示标签，注意tagsView需要按UI图顺序上下传入
     * 对比方案：后台为界面中的每个tag设置一个字段，并且多个card复用字段，那么每个字段对应的界面布局不明确，每次开发都需要询问后台，很容易出错
     * 当前方案：使用list保存tags，TagBean.position对应了布局从上到下、从左到右，反而是最好的方案
     *
     * @param tagsViews 注意需要按上下顺序传入
     */
//    protected void displayTags(List<Zra.TagBean> list, TagsView... tagsViews) {
//        if (tagsViews == null || tagsViews.length == 0) {
//            return;
//        }
//        removeTagsViews(tagsViews);
//
//        if (list == null || list.size() == 0) {
//            return;
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            TagsView.ITagsData tagsData = list.get(i);
//            if (tagsData == null) {
//                continue;
//            }
//
//            int position = tagsData.getPosition();
//            if (position < 0 || position >= tagsViews.length) {
//                continue;
//            }
//            TagsView tagsView = tagsViews[position];
//
//            if (tagsView == null) {
//                continue;
//            }
//            tagsView.bind(tagsData);
//            tagsView.setVisibility(View.VISIBLE);
//        }
//    }

//    protected void switchTagGone(TagsView tagsView) {
//        if (tagsView == null) {
//            return;
//        }
//
//        if (tagsView.getChildCount() == 0) {
//            tagsView.setVisibility(View.GONE);
//        } else {
//            tagsView.setVisibility(View.VISIBLE);
//        }
//    }

    protected void fillTvContent(TextView tv, String str) {
        if (tv == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tv.setVisibility(View.GONE);
        } else {
            tv.setText(str);
            tv.setVisibility(View.VISIBLE);
        }
    }

    protected void fillTvContent(TextView tv, String str, View v) {
        if (tv == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tv.setVisibility(View.GONE);
            if (v != null) {
                v.setVisibility(View.GONE);
            }
        } else {
            tv.setText(str);
            tv.setVisibility(View.VISIBLE);
            if (v != null) {
                v.setVisibility(View.VISIBLE);
            }
        }
    }

    protected void fillTvContent(TextView tv, String str, View... vs) {
        if (tv == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tv.setVisibility(View.GONE);
            if (vs != null) {
                for (View v : vs) {
                    v.setVisibility(View.GONE);
                }
            }
        } else {
            tv.setText(str);
            tv.setVisibility(View.VISIBLE);
            if (vs != null) {
                for (View v : vs) {
                    v.setVisibility(View.VISIBLE);
                }
            }
        }
    }

//    private void removeTagsViews(TagsView[] tagsViews) {
//        if (tagsViews == null || tagsViews.length == 0) {
//            return;
//        }
//        for (TagsView tagsView : tagsViews) {
//            if (tagsView != null) {
//                tagsView.clear();
//                tagsView.setVisibility(View.GONE);
//            }
//        }
//    }

    @Override
    public void bind(@NonNull ZraRecFlowBean data, int position) {
//        tryExposureCard(this, data, position);
    }

//    private void tryExposureCard(BaseCardViewHolder holder, ZraRecFlowBean data, int position) {
//        if (holder != null && data != null) {
//            track(data, "homePageCardExposure", position, true, holder.itemView);
//        }
//    }

}