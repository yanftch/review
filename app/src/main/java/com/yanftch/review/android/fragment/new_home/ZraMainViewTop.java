package com.yanftch.review.android.fragment.new_home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.yanftch.review.R;
import com.yanftch.review.android.fragment.new_home.adapter.ZraMainSpecialHouseListAdapter;
import com.yanftch.review.android.fragment.new_home.model.SpecialPriceHouseBean;
import com.yanftch.review.android.fragment.new_home.model.ZraEntryBean;
import com.yanftch.review.android.fragment.new_home.model.ZraMainMarketBean;
import com.yanftch.review.android.fragment.new_home.model.ZraMarketModel;
import com.yanftch.review.android.utils.DensityUtil;
import com.yanftch.review.android.utils.ScreenUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * User : yanftch
 * Date : 2021/1/7
 * Time : 14:50
 * Desc : 首页-顶部部分
 */
public class ZraMainViewTop implements ZraMainFragmentContract.Top.View {
    private final int DAY_SECONDS = 24 * 60 * 60;
    private final int HOUR_SECONDS = 60 * 60;
    private final int MINUTE_SECONDS = 60;

    private Context mContext;
    // 屏幕宽度
    private int mScreenWidth;
    private int mDp2;
    private float mDensity;

    private ZraMainFragment mZraMainFragment;
    private ZraMainFragmentContract.Top.Presenter mPresenter;

    // 金刚位入口
    private LinearLayout mLlEntryView;

    // banner
    private ConvenientBanner mConvenientBanner;
    private RelativeLayout mRlBannerContainer;

    // 特价房
    private ConstraintLayout mClDiscountContainer;
    private SimpleDraweeView mPvDiscountBgImage;
    private SimpleDraweeView mPvDiscountTitleImage;
    private LinearLayout mLlDiscountCountdownContainer;
    private TextView mTvCountdownDay, mTvCountdownDayUnit, mTvCountdownHour, mTvCountdownHourSeparator, mTvCountdownMinute, mTvCountdownMinuteSeparator, mTvCountdownSecond;
    private MyCountDownTimer mCountTimer;
    private LinearLayout mLlHsvOuterContainer;
    private RecyclerView mRvDiscountHouse;

    // 营销模块  瓷片区
    private LinearLayout mLlMarketContainer;

    public ZraMainViewTop(@NonNull ZraMainFragment zraMainFragment) {
        mZraMainFragment = zraMainFragment;
        mContext = zraMainFragment.getContext();
        mDensity = mContext.getResources().getDisplayMetrics().density;
        mScreenWidth = ScreenUtils.getScreenWidth(mContext);
        mDp2 = DensityUtil.dip2px(mContext, 2);

        View lRootView = zraMainFragment.getView().findViewById(R.id.ll_top_view);
        initView(lRootView);
    }

    /**
     * UI 初始化
     */
    private void initView(View view) {
        mLlEntryView = view.findViewById(R.id.ll_top_entry_container);
        mConvenientBanner = view.findViewById(R.id.cb_banner);
        mRlBannerContainer = view.findViewById(R.id.rl_top_banner_container);
        mClDiscountContainer = view.findViewById(R.id.cl_discount_container);
        mPvDiscountBgImage = view.findViewById(R.id.pv_bg);
        mPvDiscountTitleImage = view.findViewById(R.id.pv_title);
        mLlDiscountCountdownContainer = view.findViewById(R.id.ll_count_down_container);
        mTvCountdownDay = view.findViewById(R.id.tv_day);
        mTvCountdownHour = view.findViewById(R.id.tv_hour);
        mTvCountdownHourSeparator = view.findViewById(R.id.tv_hour_separator);
        mTvCountdownMinute = view.findViewById(R.id.tv_minute);
        mTvCountdownMinuteSeparator = view.findViewById(R.id.tv_minute_separator);
        mTvCountdownSecond = view.findViewById(R.id.tv_second);
        mTvCountdownDayUnit = view.findViewById(R.id.tv_day_unit);
        mLlHsvOuterContainer = view.findViewById(R.id.ll_hsv_anchor);
        mRvDiscountHouse = view.findViewById(R.id.rv_houses);

        mLlMarketContainer = view.findViewById(R.id.ll_market_container);


    }

    public void init() {
//        if (LocationUtil.isLocating()) {
//            LocationUtil.addListener(new LocationUtil.LocationListener() {
//                @Override
//                public void onReceiveLocation(boolean result, BDLocation location) {
//                    initCity(location);
//                }
//            });
//        } else {
//            BDLocation location = ApplicationEx.instance.getLocation();
//            initCity(location);
//        }
//
//        setCityName();
//
//        mLiveMarqueeViewNew.setActivity(mHomePageFragment.getActivity());
//
//        //banner初始化
//        initBanner();
//
//        mEvPersonalPresent.setExposureListener(() -> {
//            org.json.JSONObject properties = new org.json.JSONObject();
//            try {
//                properties.put("title", mTvPresentTip.getText());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            SensorsDataAPI.sharedInstance().track("homePageDynamicExposure", properties);
//        });
    }

    public void initData() {
        mPresenter = new ZraMainViewTopPresenter(mContext, this);
        mPresenter.start();
    }

    void setUserVisibleHint(boolean isVisibleToUser) {

//        if (mBanner != null) {
//            if (isVisibleToUser) {
//                if (mBanner.isAutoPlay()) {
//                    mBanner.startTurning();
//                }
//            } else {
//                mBanner.stopTurning();
//            }
//        }

    }

    /**
     * 渲染 banner
     */
    @Override
    public void renderBanner(List<ZraEntryBean> list) {
        if (list == null || list.isEmpty()) {
            mRlBannerContainer.setVisibility(View.GONE);
            return;
        }
        mRlBannerContainer.setVisibility(View.VISIBLE);
        if (mConvenientBanner.isTurning()) {
            mConvenientBanner.stopTurning();
        }

        mConvenientBanner.setPages(new CBViewHolderCreator<ZraMainBannerViewHolder>() {
            @Override
            public ZraMainBannerViewHolder createHolder() {
                return new ZraMainBannerViewHolder();
            }
        }, list).setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mContext, "banner click " + position, Toast.LENGTH_SHORT).show();
                // TODO:yanfeng 2021/1/8 走通用的路由跳转

            }
        });
        if (!mConvenientBanner.isTurning()) {
            mConvenientBanner.startTurning(3000);
        }
    }

    /**
     * 渲染 顶部 金刚位入口
     */
    @Override
    public void renderEntry(List<ZraEntryBean> list) {
        if (list == null || list.isEmpty()) {
            mLlEntryView.setVisibility(View.GONE);
            return;
        }

        int lMaxSize = 5; // 表示的是一行，最多显示5个，超过，则显示两行

        mLlEntryView.setVisibility(View.VISIBLE);
        mLlEntryView.removeAllViews(); // 一定先移除所有子view

        int size = list.size();

        if (size <= lMaxSize) {
            // 只显示一行
            int itemWidth = (mScreenWidth - DensityUtil.dip2px(mContext, 0)) / size; // size不可能为0
            LinearLayout topLine = new LinearLayout(mContext);
            topLine.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(itemWidth, LinearLayout.LayoutParams.WRAP_CONTENT, 1);

            for (ZraEntryBean bean : list) {
                if (bean == null) continue;
                View entryItemView = getEntryItemView(bean);

                topLine.addView(entryItemView, layoutParams);
            }
            mLlEntryView.addView(topLine);
        } else {
            // 显示两行（大于5个入口的case）
            int moreSize = size - lMaxSize;
            int itemWidth = (mScreenWidth - DensityUtil.dip2px(mContext, 0)) / lMaxSize;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(itemWidth, LinearLayout.LayoutParams.WRAP_CONTENT);

            LinearLayout topLine = new LinearLayout(mContext);
            LinearLayout bottomLine = new LinearLayout(mContext);
            topLine.setOrientation(LinearLayout.HORIZONTAL);
            bottomLine.setOrientation(LinearLayout.HORIZONTAL);
            List<ZraEntryBean> topList = list.subList(0, lMaxSize);
            List<ZraEntryBean> bottomList = list.subList(lMaxSize, size);
            for (ZraEntryBean bean : topList) {
                if (bean == null) continue;
                topLine.addView(getEntryItemView(bean), layoutParams);
            }
            for (ZraEntryBean bean : bottomList) {
                if (bean == null) continue;
                bottomLine.addView(getEntryItemView(bean), layoutParams);
            }
            mLlEntryView.addView(topLine);
            // 改需求了，只显示1行，超过5个的就不显示超出的了
            // mLlEntryView.addView(bottomLine);
        }
    }

    private View getEntryItemView(@NonNull ZraEntryBean bean) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(mContext).inflate(R.layout.zra_layout_home_top_entry_item, null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);

        SimpleDraweeView pictureView = view.findViewById(R.id.pv_image);
        // TODO:yanfeng 2021/1/8 替换下边的方法加载图片
        pictureView.setImageURI(bean.getImg());
//            pictureView.setController(ImageUtil.frescoController(bean.getImage()));
        TextView textView = view.findViewById(R.id.tv_title);
        textView.setText(bean.getTitle());

        // 角标
        SimpleDraweeView pvIcon = view.findViewById(R.id.pv_live);
        if (!TextUtils.isEmpty(bean.getIcon())) {
            pvIcon.setImageURI(bean.getIcon());
        }

        SVGAImageView svIcon = view.findViewById(R.id.sv_live);
        if (!TextUtils.isEmpty(bean.getIconSvga())) {
            // TODO:yanfeng 2021/1/8 加载 SVGA
            showSvgaView(svIcon, bean.getIconSvga());
        }

        view.setOnClickListener(v -> {
            Toast.makeText(mContext, "click " + bean.getTitle(), Toast.LENGTH_SHORT).show();
            // TODO:yanfeng 2021/1/8 替换成下边的方法
//                Routers.open(mCtx, bean.getTarget(), bean.getParameter());
        });
        return view;
    }

    private void showSvgaView(SVGAImageView svgaImageView, String svga) {
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
                    svgaImageView.startAnimation();
                }
            }

            @Override
            public void onError() {

            }
        });
    }

    /**
     * 渲染特价房模块数据
     */
    @Override
    public void renderSpecialHouseInfo(SpecialPriceHouseBean specialPriceHouseBean) {
        if (specialPriceHouseBean == null) {
            mClDiscountContainer.setVisibility(View.GONE);
            return;
        }
        mClDiscountContainer.setVisibility(View.VISIBLE);
        // 背景图
        mPvDiscountBgImage.setImageURI(specialPriceHouseBean.getActBaseImg());
        // TODO:yanfeng 2021/1/10 替换下边的方法
//        mPvDiscountBgImage.setController(ImageUtil.frescoController(specialPriceHouseBean.getActBaseImg()));
        // 标题图 mPvTitle.setController(ImageUtil.frescoController(entity.getTitleImage()));
        mPvDiscountTitleImage.setImageURI(specialPriceHouseBean.getTitleImage());
        // TODO:yanfeng 2021/1/10 替换下边的方法
//        mPvDiscountTitleImage.setController(ImageUtil.frescoController(specialPriceHouseBean.getTitleImage()));

        // 倒计时
        if (specialPriceHouseBean.getSurplusTime() > 0) {
            mLlDiscountCountdownContainer.setVisibility(View.VISIBLE);
            if (specialPriceHouseBean.getSurplusTime() > DAY_SECONDS) { // 大于1天，只显示 N 天
                int days = (int) Math.ceil(specialPriceHouseBean.getSurplusTime() * 1.0d / DAY_SECONDS);
                long distanceSeconds = specialPriceHouseBean.getSurplusTime() - DAY_SECONDS;
                mTvCountdownDay.setText(formatTime(days));
                mTvCountdownDay.setVisibility(View.VISIBLE);
                mTvCountdownDayUnit.setVisibility(View.VISIBLE);
                mTvCountdownHour.setVisibility(View.GONE);
                mTvCountdownHourSeparator.setVisibility(View.GONE);
                mTvCountdownMinute.setVisibility(View.GONE);
                mTvCountdownMinuteSeparator.setVisibility(View.GONE);
                mTvCountdownSecond.setVisibility(View.GONE);

                mLlDiscountCountdownContainer.postDelayed(() -> {
                    startCountDown((int) (specialPriceHouseBean.getSurplusTime() - distanceSeconds));
                }, distanceSeconds * 1000);
            } else {
                startCountDown((int) specialPriceHouseBean.getSurplusTime());
            }
        } else {
            mLlDiscountCountdownContainer.setVisibility(View.GONE);
        }

        // 房间横滑列表
        List<SpecialPriceHouseBean.SpecialPriceHouseVosBean> list = specialPriceHouseBean.getSpeicalPriceHouseVos();
        if (list == null || list.isEmpty()) {
            mClDiscountContainer.setVisibility(View.GONE);
        } else {
            mClDiscountContainer.setVisibility(View.VISIBLE);
            mLlHsvOuterContainer.setVisibility(View.VISIBLE);

            mRvDiscountHouse.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
            mRvDiscountHouse.setAdapter(new ZraMainSpecialHouseListAdapter(mContext, list));
            // TODO:yanfeng 2021/1/11 addItemDecoration 之前，需要判断是否已有了，如果有，则不能再添加！！！！！！！记得判断一下

            mRvDiscountHouse.addItemDecoration(new RightWhiteRecyclerDecoration(mContext));
        }
    }

    /**
     * 开启特价房倒计时
     */
    private void startCountDown(int time) {
        if (mCountTimer != null) {
            mCountTimer.cancel();
        }
        mCountTimer = new MyCountDownTimer(1000 * time, 1000);
        mCountTimer.start();
    }

    class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @SuppressLint("DefaultLocale")
        @Override
        public void onTick(long millisUntilFinished) {
            showTime(Math.round(millisUntilFinished / 1000.0f));
        }

        @Override
        public void onFinish() {
            mLlDiscountCountdownContainer.setVisibility(View.GONE);
            cancel();
        }
    }

    public void showTime(long time) {
        mTvCountdownDay.setVisibility(View.GONE);
        mTvCountdownDayUnit.setVisibility(View.GONE);
        mTvCountdownHour.setVisibility(View.VISIBLE);
        mTvCountdownHourSeparator.setVisibility(View.VISIBLE);
        mTvCountdownMinute.setVisibility(View.VISIBLE);
        mTvCountdownMinuteSeparator.setVisibility(View.VISIBLE);
        mTvCountdownSecond.setVisibility(View.VISIBLE);
        int hour = (int) (time / HOUR_SECONDS);
        int minute = (int) ((time - hour * HOUR_SECONDS) / MINUTE_SECONDS);
        int second = (int) (time % MINUTE_SECONDS);
        mTvCountdownHour.setText(formatTime(hour));
        mTvCountdownMinute.setText(formatTime(minute));
        mTvCountdownSecond.setText(formatTime(second));
    }

    private String formatTime(int time) {
        if (time < 10) {
            return "0" + time;
        }
        return String.valueOf(time);
    }

    /**
     * 营销区域  瓷片区
     */
    @Override
    public void renderMarketing(List<ZraMarketModel> list) {
        if (list == null || list.isEmpty()) {
            mLlMarketContainer.setVisibility(View.GONE);
            return;
        }
        mLlMarketContainer.setVisibility(View.VISIBLE);
        mLlMarketContainer.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);

        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) continue;
            mLlMarketContainer.addView(getMarketItemView(list.get(i)), layoutParams);
            if (i == 0 && size == 2) {
                mLlMarketContainer.addView(new View(mContext), new LinearLayout.LayoutParams(DensityUtil.dip2px(mContext, 16f), ViewGroup.LayoutParams.WRAP_CONTENT));
            }
        }
    }

    private View getMarketItemView(@NonNull ZraMarketModel model) {
        if (model.isSingleType()) {
            return getMarketSingleView(model);
        } else if (model.isMulType()) {
            return getMarketMulView(model);
        }
        return new View(mContext);
    }

    private View getMarketSingleView(@NonNull ZraMarketModel model) {
        List<ZraMainMarketBean> list = model.getList();
        if (list == null || list.isEmpty()) return new View(mContext);
        ZraMainMarketBean zraMainMarketBean = list.get(0);

        View view = LayoutInflater.from(mContext).inflate(R.layout.zra_layout_market_single_view, null, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvSubTitle = view.findViewById(R.id.tv_sub_title);
        SimpleDraweeView pvImage = view.findViewById(R.id.pv_image);

        tvTitle.setText(zraMainMarketBean.getTitle());
        tvSubTitle.setText(zraMainMarketBean.getSubTitle());

        // TODO:yanfeng 2021/1/11 替换图片加载方式
        // mPvImage.setController(ImageUtil.frescoController(bean.houseTypePic));
        pvImage.setImageURI(zraMainMarketBean.getImg());
        // TODO:yanfeng 2021/1/12 重新处理图片的宽高

        view.setOnClickListener(v -> {
            // TODO:yanfeng 2021/1/11 进入房型详情页/项目详情页？   后端配置路由实现吗？
            Toast.makeText(mContext, "click single", Toast.LENGTH_SHORT).show();
        });
        return view;
    }

    /**
     * 内部还有数组，需要遍历添加子视图
     */
    private View getMarketMulView(@NonNull ZraMarketModel model) {
        List<ZraMainMarketBean> list = model.getList();
        if (list == null || list.isEmpty()) return new View(mContext);

        LinearLayout linearLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ZraMainMarketBean zraMainMarketBean = list.get(i);
            if (zraMainMarketBean == null) continue;

            View view = LayoutInflater.from(mContext).inflate(R.layout.zra_layout_market_active_view, null, false);
            TextView tvButton = view.findViewById(R.id.tv_btn);
            TextView tvTitle = view.findViewById(R.id.tv_title);
            TextView tvSubTitle = view.findViewById(R.id.tv_sub_title);
            SimpleDraweeView pvImage = view.findViewById(R.id.pv_image);

            tvTitle.setText(zraMainMarketBean.getTitle());
            tvSubTitle.setText(zraMainMarketBean.getSubTitle());
            tvButton.setText(zraMainMarketBean.getButtonTitle());

            // TODO:yanfeng 2021/1/11 替换图片加载方式
            // mPvImage.setController(ImageUtil.frescoController(bean.houseTypePic));
            pvImage.setImageURI(zraMainMarketBean.getImg());
            // TODO:yanfeng 2021/1/12 重新处理图片的宽高

            tvButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO:yanfeng 2021/1/12 调接口，刷新按钮状态
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO:yanfeng 2021/1/11 进入房型详情页/项目详情页？   后端配置路由实现吗？
                    Toast.makeText(mContext, "click single", Toast.LENGTH_SHORT).show();
                }
            });
            linearLayout.addView(view, layoutParams);
            if (i == 0 && size == 2) {
                linearLayout.addView(new View(mContext), new ViewGroup.LayoutParams(DensityUtil.dip2px(mContext,8f), ViewGroup.LayoutParams.WRAP_CONTENT));
            }
        }
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    @Override
    public void renderMediaInfo() {

    }

    @Override
    public void renderRecTitle() {

    }

    @Override
    public void setPresenter(ZraMainFragmentContract.Top.Presenter presenter) {

    }

    @Override
    public boolean isActive() {
        return mZraMainFragment != null && mZraMainFragment.isAdded();
    }

    @Override
    public Context getViewContext() {
        if (mZraMainFragment == null) {
            return null;
        } else {
            return mZraMainFragment.getContext();
        }
    }

    public void onPause() {
        if (mConvenientBanner != null) {
            mConvenientBanner.stopTurning();
        }

    }

    public void onResume() {
        if (mConvenientBanner != null && !mConvenientBanner.isTurning()) {
            mConvenientBanner.startTurning(3000);
        }
    }

    public void onDestroy() {
    }
}
