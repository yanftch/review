package com.yanftch.review.android.pages.smartrefreshlayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;

import java.util.ArrayList;

public class SmartActivity2 extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CommonAdapter mAdapter;
    private ArrayList<String> mStringArrayList;
    private NestedScrollView mNestedScrollView;
    private TextView mTvBar;
    private LinearLayout mLlTitleBar;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_smart2);

        initView();

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_list);
        mNestedScrollView = findViewById(R.id.nsv);
        mTvBar = findViewById(R.id.tv_bar);
        mLlTitleBar = findViewById(R.id.ll_titlebar);



        mStringArrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mStringArrayList.add("item " + i);
        }
        mAdapter = new CommonAdapter(mStringArrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(mAdapter);

        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY >= 456) {
                    mTvBar.setVisibility(View.VISIBLE);
                    mLlTitleBar.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                } else {
                    mTvBar.setVisibility(View.INVISIBLE);
                    mLlTitleBar.setBackgroundColor(ContextCompat.getColor(mContext, R.color.dsb_ripple_color_focused));
                }
            }
        });
    }
}
