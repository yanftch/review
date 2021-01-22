package com.yanftch.review.android.fragment.new_home;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.tabs.TabLayout;
import com.yanftch.review.R;
import com.yanftch.review.android.fragment.new_home.model.TabBean;
import com.yanftch.review.android.utils.DensityUtil;

import java.util.List;

public class ZraMainFragment extends Fragment {


    private ZraMainViewTop mTopView;
    private View mRootView;
    private RelativeLayout mRlHead;
    private View mTitleBackGround;
    private TextView mTitle;

    private FragmentActivity mFragmentActivity;

    HomeNestedScrollView mNestScrollView;
    protected float mDensity;
    private TabLayout mTabLayoutStable;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private boolean mIsVisible = false;

    public ZraMainFragment() {
        // Required empty public constructor
    }

    public static ZraMainFragment newInstance(String param1, String param2) {
        ZraMainFragment fragment = new ZraMainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mFragmentActivity = getActivity();

        mLimit = DensityUtil.dip2px(getActivity(), 24);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mDensity = displayMetrics.density;
    }

    private int mSelectedTab = 0;

    public void updatePosition(int position) {
        mSelectedTab = position;
        TabLayout.Tab tabAt = mTabLayoutStable.getTabAt(mSelectedTab);
        mTabLayoutStable.selectTab(tabAt);
    }

    public void renderTabData(List<TabBean> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();

        for (int i = 0; i < size; i++) {
            TabBean tabBean = list.get(i);
            if (tabBean == null) continue;

            // 添加tab
            TabLayout.Tab tab = mTabLayoutStable.newTab();
            View view = LayoutInflater.from(mFragmentActivity).inflate(R.layout.zra_item_tab_custom_view, null, false);
            ((TextView) view.findViewById(R.id.text_view)).setText(tabBean.getTitle());
            tab.setCustomView(view);
            mTabLayoutStable.addTab(tab);
            if (i == 0 && tab.getCustomView() != null) {
                ((TextView) tab.getCustomView().findViewById(R.id.text_view)).setTextColor(ContextCompat.getColor(mFragmentActivity, R.color.black));
                // 本次不要此功能
                tab.getCustomView().findViewById(R.id.v_shadow).setBackgroundColor(ContextCompat.getColor(mFragmentActivity, R.color.color_FF961E_30));
            }
        }

        mTabLayoutStable.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView == null) return;
                ((TextView) customView.findViewById(R.id.text_view)).setTextColor(ContextCompat.getColor(mFragmentActivity, R.color.black));
                customView.findViewById(R.id.v_shadow).setBackgroundColor(ContextCompat.getColor(mFragmentActivity, R.color.color_FF961E_30));
                mTopView.mRecViewPager.setCurrentItem(tab.getPosition());
                mTopView.updatePosition(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView == null) return;
                ((TextView) customView.findViewById(R.id.text_view)).setTextColor(ContextCompat.getColor(mFragmentActivity, R.color.color_ct1_40));
                customView.findViewById(R.id.v_shadow).setBackgroundColor(ContextCompat.getColor(mFragmentActivity, R.color.transparent));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.zra_fragment_main_page, container, false);
        }
        initView();
        mNestScrollView = mRootView.findViewById(R.id.osv);


        mNestScrollView.setNestedScrollState(mRootView, (int) mDensity * 112);

        mRootView.post(new Runnable() {
            @Override
            public void run() {
                initAnimatorOnScrolling(1);

            }
        });
        return mRootView;
    }

    private void initAnimatorOnScrolling(int height) {
        View llTabTop = mRootView.findViewById(R.id.tb_rec_title_stable);
        View llTab = mRootView.findViewById(R.id.tb_rec_title);

        mNestScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            private int mLimit = height;
            private float mPercent;

            final int[] mLocation = new int[2];

            boolean mIsSticky = true;

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                //固定头的显隐
                switchStickyViewVisibilityOnScroll();

                int trans = Math.min(scrollY, mLimit);
                float percent = trans * 1.0f / mLimit * 1.0f;
                Log.e("debug_ZraMainFragment:", "onScrollChange------NSV==> " + ", scrollY = " + scrollY + ", trans = " + trans + ", percent = " + percent);
                if (percent > 1) {
                    percent = 1.0f;
                }

                if (percent < 0.9) {

                    mTitleBackGround.setAlpha(percent);
                    mTitle.setVisibility(View.GONE);
                } else {
                    mTitleBackGround.setAlpha(1);
                    mTitle.setVisibility(View.VISIBLE);
                }

            }

            private void switchStickyViewVisibilityOnScroll() {
                llTabTop.getLocationOnScreen(mLocation);
                int stickyYOnScreen = mLocation[1];
                llTab.getLocationOnScreen(mLocation);
                int yOnScreen = mLocation[1];

                if (yOnScreen <= stickyYOnScreen) {
                    //固定头
                    llTabTop.setVisibility(View.VISIBLE);

                    mIsSticky = true;
                } else {
                    if (!mIsSticky) {
                        return;
                    }
                    mIsSticky = false;
                    llTabTop.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private int mLimit;

    private void initView() {
        mTabLayoutStable = mRootView.findViewById(R.id.tb_rec_title_stable);

        mRlHead = mRootView.findViewById(R.id.zra_rl_head_rent_homepage);
        mTitleBackGround = mRootView.findViewById(R.id.zra_view_title_background);
        mNestScrollView = mRootView.findViewById(R.id.osv);
        mTitle = mRootView.findViewById(R.id.tv_title);

        Log.e("debug_ZraMainFragment:", "initView==> " + "mLimit = " + mLimit);

//        mNestScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//                int trans = Math.min(scrollY, mLimit);
//                float percent = trans * 1.0f / mLimit * 1.0f;
//                Log.e("debug_ZraMainFragment:", "onScrollChange==> " + ", scrollY = " + scrollY + ", trans = " + trans + ", percent = " + percent);
//                if (percent > 1) {
//                    percent = 1.0f;
//                }
//
//                if (percent < 0.9) {
//
//                    mTitleBackGround.setAlpha(percent);
//                    mTitle.setVisibility(View.GONE);
//                } else {
//                    mTitleBackGround.setAlpha(1);
//                    mTitle.setVisibility(View.VISIBLE);
//                }
//
//
//            }
//        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTopView();
    }

    /**
     * 初始化上半部分
     */
    private void initTopView() {
        mTopView = new ZraMainViewTop(this);
        mTopView.setUserVisibleHint(mIsVisible);
        mTopView.init();
        mTopView.initData();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mTopView != null) {
            mTopView.onPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mTopView != null) {
            mTopView.onResume();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mIsVisible = isVisibleToUser;
        if (mTopView != null) {
            mTopView.setUserVisibleHint(isVisibleToUser);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTopView != null) {
            mTopView.onDestroy();
        }
    }
}