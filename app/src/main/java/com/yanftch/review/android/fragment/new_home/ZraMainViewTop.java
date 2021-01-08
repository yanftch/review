package com.yanftch.review.android.fragment.new_home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.drawee.view.SimpleDraweeView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.yanftch.review.R;
import com.yanftch.review.android.fragment.new_home.model.ZraEntryBean;
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

    private Context mContext;
    // 屏幕宽度
    private int mScreenWidth;
    private int mDp2;
    private float mDensity;

    private ZraMainFragment mZraMainFragment;
    private ZraMainFragmentContract.Top.Presenter mPresenter;

    // 金刚位入口
    private LinearLayout mLlEntryView;

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

    @Override
    public void renderBanner() {

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
            mLlEntryView.addView(bottomLine);
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

    @Override
    public void renderSpecialHouseInfo() {

    }

    @Override
    public void renderMarketing() {

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
}
