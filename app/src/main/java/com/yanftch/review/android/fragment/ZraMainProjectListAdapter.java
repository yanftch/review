package com.yanftch.review.android.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.yanftch.review.R;
import com.yanftch.review.android.fragment.new_home.model.Style;
import com.yanftch.review.android.fragment.new_home.model.ZraRecommendzryEntity;
import com.yanftch.review.android.utils.DensityUtil;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * User : yanftch
 * Date : 2021/1/13
 * Time : 15:13
 * Desc : 首页-项目列表adapter
 */
public class ZraMainProjectListAdapter extends RecyclerView.Adapter<ZraMainProjectListAdapter.MyViewHolder> {
    public List<ZraRecommendzryEntity.RecommendZRY> mDataList = new ArrayList<>();

    private Context mContext;
    private int mPicWith;
    private int mPicHeight;
    private String mSvgaPth = "svga/play_activities_living.svga";

    public ZraMainProjectListAdapter(Context context  , List<ZraRecommendzryEntity.RecommendZRY> list) {
        this.mContext = context;
        this.mDataList = list;
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        // 屏幕宽度（像素）
        int mWith = metric.widthPixels;
        // 图片宽度取值屏幕宽度的 2/3
        mPicWith = (mWith - DensityUtil.dip2px(mContext, 16 * 2));
        mPicHeight = mPicWith * 2 / 3;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root;
        root = LayoutInflater.from(mContext).inflate(R.layout.zra_item_main_yu, parent, false);
        return new MyViewHolder(root, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        ZraRecommendzryEntity.RecommendZRY bean = mDataList.get(i);
        if (bean == null) {
            return;
        }


        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(mPicWith, mPicHeight);
        myViewHolder.mPvPic.setLayoutParams(lp);

        if (bean.getImgs() != null && bean.getImgs().size() > 0) {
            if (bean.getImgs().get(0) != null) {
                myViewHolder.mPvPic.setImageURI(bean.getImgs().get(0).getUrl());
                // TODO:yanfeng 2021/1/13 替换如下方法
//            myViewHolder.mPvPic.setImageUri(bean.getImgs().get(0).getUrl());
//            myViewHolder.mPvPic.display();
            }
        }

        // 直播UI
        if (bean.isInLiving()) {
            myViewHolder.mLlLivingContainer.setVisibility(View.VISIBLE);
            String svgaPth = "svga/play_activities_living.svga";
            showSvgaLiveState(myViewHolder.mSVGAImageView, svgaPth);
        } else {
            myViewHolder.mLlLivingContainer.setVisibility(View.GONE);
        }

        // 标题
        myViewHolder.mTvTitle.setText(TextUtils.isEmpty(bean.getTitle()) ? "" : bean.getTitle());
        // 顶部标签
        myViewHolder.mTvTopTag.setText(TextUtils.isEmpty(bean.getRapidLabel()) ? "" : bean.getRapidLabel());
        myViewHolder.mTvTopTag.setVisibility(TextUtils.isEmpty(bean.getRapidLabel()) ? View.INVISIBLE : View.VISIBLE);
        // 价格
        myViewHolder.mTvPrice.setText(TextUtils.isEmpty(bean.getPrice()) ? "" : String.format(Locale.getDefault(), "¥%s", bean.getPrice()));
        // 单价
        myViewHolder.mTvPriceUnit.setText(TextUtils.isEmpty(bean.getPrice_unit()) ? "" : bean.getPrice_unit());

        // 划线价
        Style priceStyle = bean.getPriceStyle();
        Style originalPriceStyle = bean.getPrePriceStyle();
        String originalPrice; // 原价
        if (TextUtils.isEmpty(bean.getPrePrice())) {
            originalPrice = "";
        } else {
            originalPrice = bean.getUnit() + bean.getPrePrice();
        }

        String price = bean.getPrice(); // 优惠价
        if (TextUtils.isEmpty(originalPrice)) {  // 无原价时，按照历史版本显示，显示 优惠价
            myViewHolder.mTvOriginalPrice.setVisibility(View.GONE);
            if (priceStyle != null && !TextUtils.isEmpty(priceStyle.getColor())) {
                try {
                    int textColor = Color.parseColor(priceStyle.getColor());
                    myViewHolder.mTvPrice.setTextColor(textColor);
                    myViewHolder.mTvPriceUnit.setTextColor(textColor);
                } catch (Exception e) {
                    int textColor = ContextCompat.getColor(mContext, R.color.color_ct1_85);
                    myViewHolder.mTvPrice.setTextColor(textColor);
                    myViewHolder.mTvPriceUnit.setTextColor(textColor);
                }
            } else {
                int textColor = ContextCompat.getColor(mContext, R.color.color_ct1_85);
                myViewHolder.mTvPrice.setTextColor(textColor);
                myViewHolder.mTvPriceUnit.setTextColor(textColor);
            }
        } else {
            myViewHolder.mTvOriginalPrice.setVisibility(View.VISIBLE);
            myViewHolder.mTvOriginalPrice.setPaintFlags(myViewHolder.mTvOriginalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            myViewHolder.mTvOriginalPrice.setText(originalPrice);

            if (priceStyle != null && !TextUtils.isEmpty(priceStyle.getColor())) {
                try {
                    int textColor = Color.parseColor(priceStyle.getColor());
                    myViewHolder.mTvPrice.setTextColor(textColor);
                    myViewHolder.mTvPriceUnit.setTextColor(textColor);
                } catch (Exception e) {
                    int textColor = Color.parseColor("#FF3737");
                    myViewHolder.mTvPrice.setTextColor(textColor);
                    myViewHolder.mTvPriceUnit.setTextColor(textColor);
                }
            } else {
                int textColor = Color.parseColor("#FF3737");
                myViewHolder.mTvPrice.setTextColor(textColor);
                myViewHolder.mTvPriceUnit.setTextColor(textColor);
            }
        }

        // 副标题
        String distance = bean.getDistance();
        String distanceText = TextUtils.isEmpty(distance) ? "" : " | 距您" + bean.getDistance();
        String subTitle = String.format(Locale.getDefault(), "%s%s", TextUtils.isEmpty(bean.getNewSubTitle()) ? "" : bean.getNewSubTitle(), distanceText);

        myViewHolder.mTvSubTitle.setText(subTitle);
        if (TextUtils.isEmpty(bean.getNewSubTitle()) && TextUtils.isEmpty(bean.getDistance())) {
            myViewHolder.mTvSubTitle.setVisibility(View.INVISIBLE);
        } else {
            myViewHolder.mTvSubTitle.setVisibility(View.VISIBLE);
        }

        // 描述信息
        if (!TextUtils.isEmpty(bean.getAuthor()) && !TextUtils.isEmpty(bean.getEvaluate())) {
            String author = bean.getAuthor() + " : ";
            String desc = String.format("%s%s", TextUtils.isEmpty(author) ? "" : author, TextUtils.isEmpty(bean.getEvaluate()) ? "" : bean.getEvaluate());
            SpannableString spannableString = new SpannableString(desc);
            ForegroundColorSpan color_ct1_85 = new ForegroundColorSpan(mContext.getResources().getColor(R.color.color_ct1_85));
            spannableString.setSpan(color_ct1_85, 0, author.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            myViewHolder.mTvDesc.setText(spannableString);
        } else {
            myViewHolder.mTvDesc.setText("");
        }

        // 底部标签
        myViewHolder.mTvBtnTag.setText(TextUtils.isEmpty(bean.getTextAndNumber()) ? "" : bean.getTextAndNumber());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, TextUtils.isEmpty(bean.getTextAndNumber()) ? 0f : 1f);
        myViewHolder.mTvBtnTag.setLayoutParams(layoutParams);

        LinearLayout.LayoutParams layoutParamsCall = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsCall.setMarginStart(TextUtils.isEmpty(bean.getTextAndNumber()) ? DensityUtil.dip2px(mContext,0f) : DensityUtil.dip2px(mContext,24f));
        myViewHolder.mTvCall.setLayoutParams(layoutParamsCall);

        // 咨询
        myViewHolder.mTvCall.setOnClickListener(v -> {
            String projectId = "";
            if (bean.getParameter() != null) {
                String parameter = bean.getParameter();
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(parameter);
                    projectId = jsonObject.getString("projectId");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(projectId)) {
                if (mContext instanceof FragmentActivity) {
                    String finalProjectId = projectId;
                    // TODO:yanfeng 2021/1/13 放开如下代码
                    // TODO:yanfeng 2021/1/13 放开如下代码
                    // TODO:yanfeng 2021/1/13 放开如下代码
                    // TODO:yanfeng 2021/1/13 放开如下代码
//                    ContractKeeperUtils.contractKeeper((FragmentActivity) mContext, projectId, "", ContractKeeperUtils.FROM_ZRA_HOME_PAGE_RECOMMAND_ZRA, ContractKeeperUtils.FROM_TYPE_CONTACT_KEEPER, () -> toBook(finalProjectId));
                }
            }
        });

        myViewHolder.mRootView.setOnClickListener(v -> {
            // TODO:yanfeng 2021/1/13 放开如下代码 所有所有
            // TODO:yanfeng 2021/1/13 放开如下代码 所有所有
            // TODO:yanfeng 2021/1/13 放开如下代码  所有所有
            // TODO:yanfeng 2021/1/13 放开如下代码 所有所有
//            Routers.open(mContext, bean.getTarget(), LazyUtil.toBundle(bean.getParameter()));

//            Map<String, Object> map = new HashMap<>();
//            map.put("location", i);
//            map.put("pageName", TrackUtils.KEY_PAGE_NAME_ZRA_HOME_PAGE);
//            if (bean.getParameter() != null) {
//                String parameter = bean.getParameter();
//                JSONObject jsonObject;
//                try {
//                    jsonObject = new JSONObject(parameter);
//                    map.put("projectId", jsonObject.getString("projectId"));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//            map.put("pugcTest", mUgcName);
//            map.put("promoteAB", ABTestConstant.getZyupromoteName(mContext));
//            TrackUtils.trackEvent("zryCardClick", map);

        });

        // TODO:yanfeng 2021/1/13 放开如下代码 所有所有 ？？？？？？？？？？没说有曝光埋点啊
        // TODO:yanfeng 2021/1/13 放开如下代码 所有所有 ？？？？？？？？？？没说有曝光埋点啊
        // TODO:yanfeng 2021/1/13 放开如下代码 所有所有 ？？？？？？？？？？没说有曝光埋点啊
        // TODO:yanfeng 2021/1/13 放开如下代码 所有所有 ？？？？？？？？？？没说有曝光埋点啊
        // TODO:yanfeng 2021/1/13 放开如下代码 所有所有 ？？？？？？？？？？没说有曝光埋点啊
        // TODO:yanfeng 2021/1/13 放开如下代码 所有所有 ？？？？？？？？？？没说有曝光埋点啊
        // 曝光埋点
//        myViewHolder.mRootView.setTag(TrackerConstants.VIEW_TAG_UNIQUE_NAME, ZraExposureConstants.ZRA_PROJECT_CARD_ITEM);
//        HashMap<String, Object> trackerParams = new HashMap<>();
//        JSONObject object = new JSONObject();
//        try {
//            String parameter = TextUtils.isEmpty(bean.getParameter()) ? "" : bean.getParameter();
//            JSONObject jsonObject = new JSONObject(parameter);
//            object.put("projectId", jsonObject.getString("projectId"));
//            object.put("pageName", TrackUtils.KEY_PAGE_NAME_ZRA_HOME_PAGE);
//            trackerParams.put("params", object);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        myViewHolder.mRootView.setTag(TrackerConstants.VIEW_TAG_PARAM, trackerParams);
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull MyViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (holder.mSVGAImageView == null) {
            return;
        }
        SVGAImageView svgaImageView = holder.mSVGAImageView;
        showSvgaLiveState(svgaImageView, mSvgaPth);
    }


    /**
     * 展示直播状态动画
     */
    private void showSvgaLiveState(SVGAImageView svgaImageView, String svga) {
        if (svgaImageView == null) return;

        if (TextUtils.isEmpty(svga)) {
            svgaImageView.setVisibility(View.GONE);
            return;
        }
        SVGAParser parser = new SVGAParser(mContext);
        parser.decodeFromAssets(svga, new SVGAParser.ParseCompletion() {
            @Override
            public void onComplete(@NotNull SVGAVideoEntity svgaVideoEntity) {
                if (mContext instanceof Activity && !((Activity) mContext).isFinishing()) {
                    SVGADrawable drawable = new SVGADrawable(svgaVideoEntity);
                    svgaImageView.setVisibility(View.VISIBLE);
                    svgaImageView.setImageDrawable(drawable);
                    svgaImageView.setVideoItem(svgaVideoEntity);
                    svgaImageView.startAnimation();
                }
            }

            @Override
            public void onError() {

            }
        });
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        View mRootView;
        SimpleDraweeView mPvPic;
        //        PictureView mPvPic;
        TextView mTvTitle;
        private TextView mTvSubTitle;
        LinearLayout mLlRoot;
        private TextView mTvTopTag;
        private TextView mTvPrice;
        private TextView mTvPriceUnit;
        private TextView mTvDesc;
        private TextView mTvBtnTag;
        private TextView mTvCall;
        private TextView mTvOriginalPrice; // 原价
        // 直播UI
        private LinearLayout mLlLivingContainer;
        private SVGAImageView mSVGAImageView;

        MyViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            this.mRootView = itemView;
                this.mPvPic = mRootView.findViewById(R.id.pv_pic);
                this.mTvTitle = mRootView.findViewById(R.id.tv_title);
                this.mTvTopTag = mRootView.findViewById(R.id.tv_tag);
                this.mTvPrice = mRootView.findViewById(R.id.tv_price);
                this.mTvPriceUnit = mRootView.findViewById(R.id.tv_price_unit);
                this.mTvSubTitle = mRootView.findViewById(R.id.tv_sub_title);
                this.mTvDesc = mRootView.findViewById(R.id.tv_desc);
                this.mTvBtnTag = mRootView.findViewById(R.id.tv_btn_tag);
                this.mTvCall = mRootView.findViewById(R.id.tv_call);
                this.mTvOriginalPrice = mRootView.findViewById(R.id.tv_original_price);
                this.mLlLivingContainer = mRootView.findViewById(R.id.ll_live_status);
                this.mSVGAImageView = mRootView.findViewById(R.id.svga_living);
        }
    }
}
