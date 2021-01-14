package com.yanftch.review.android.fragment.new_home;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.fastjson.JSONObject;
import com.yanftch.review.R;
import com.yanftch.review.android.adapter.ZraRecFlowAdapter;
import com.yanftch.review.android.fragment.new_home.model.DataUtils;
import com.yanftch.review.android.fragment.new_home.model.ZraRecFlowBean;

import java.util.ArrayList;
import java.util.List;

public class ZraMainRecFlowFragment extends Fragment {

    public ZraMainRecFlowFragment() {
    }

    private float mDensity;

    private ZraRecFlowAdapter mFlowAdapter;
    private FragmentActivity mFragmentActivity;
    private RecyclerView mRv;
    private List<ZraRecFlowBean> mList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentActivity = getActivity();

        if (mFragmentActivity != null) {
            DisplayMetrics displayMetrics = mFragmentActivity.getResources().getDisplayMetrics();
            mDensity = displayMetrics.density;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zra_fragment_main_rec_flow, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRv = view.findViewById(R.id.rv_list);

        mList = JSONObject.parseArray(DataUtils.recJson, ZraRecFlowBean.class);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        mRv.setLayoutManager(layoutManager);

        mFlowAdapter = new ZraRecFlowAdapter(mFragmentActivity, 0);

        mFlowAdapter.setData(mList,1);
        mRv.setAdapter(mFlowAdapter);

        //添加分割线
        int itemDecorationCount = mRv.getItemDecorationCount();
        if (itemDecorationCount == 0) {
            MainHomeFeedDividerItemDecoration staggeredDividerItemDecoration = new MainHomeFeedDividerItemDecoration(mDensity);
            mRv.addItemDecoration(staggeredDividerItemDecoration);
        }
    }
}
