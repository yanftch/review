package com.yanftch.review.android.pages.smartrefreshlayout;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.yanftch.review.R;

import java.util.ArrayList;


/**
 * SmartRefreshLayout + CoordinatorLayout + AppBarLayout + RecyclerView
 * 实现 上拉加载，下拉刷新 头部悬停效果
 *
 */
public class SmartActivity1 extends AppCompatActivity {

    private SmartRefreshLayout mSmartRefreshLayout;
    private AppBarLayout mAppBarLayout;
    private LinearLayout mLlTargetView;
    private RecyclerView mRecyclerView;
    private CommonAdapter mAdapter;
    private ArrayList<String> mStringList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart1);
        initView();
    }

    private void initView() {
        mSmartRefreshLayout = findViewById(R.id.refreshLayout);
        mAppBarLayout = findViewById(R.id.appbar);
        mLlTargetView = findViewById(R.id.ll_target_view);
        mRecyclerView = findViewById(R.id.rv_list);


        mStringList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mStringList.add("item " + i);
        }
        mAdapter = new CommonAdapter(mStringList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        mRecyclerView.setAdapter(mAdapter);


        mSmartRefreshLayout.setEnableRefresh(true); // 设置支持下拉刷新
        mSmartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            onRefresh();
        });

        mSmartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            onLoadMore();
        });


    }

    private void onRefresh() {
        mSmartRefreshLayout.getLayout().postDelayed(() -> {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add("refresh item " + i);
            }
            mAdapter.setData(list);
            mSmartRefreshLayout.finishRefresh();
        }, 2000);
    }

    private void onLoadMore() {
        mSmartRefreshLayout.getLayout().postDelayed(() -> {
            if (mAdapter.getItemCount() > 50) {
                Toast.makeText(this, "全部加载完毕了~", Toast.LENGTH_SHORT).show();
                mSmartRefreshLayout.finishLoadMoreWithNoMoreData();
                return;
            }
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add("more item " + i);
            }
            mAdapter.appendData(list);
            mSmartRefreshLayout.finishLoadMore();
        }, 2000);
    }
}
