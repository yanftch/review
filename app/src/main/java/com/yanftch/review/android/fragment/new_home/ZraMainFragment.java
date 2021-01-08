package com.yanftch.review.android.fragment.new_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yanftch.review.R;

public class ZraMainFragment extends Fragment {


    private ZraMainViewTop mTopView;
    private View mRootView;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.zra_fragment_main_page, container, false);

        }
        return mRootView;
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