package com.yanftch.review.android.pages;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;

import java.util.ArrayList;

public class NestedScrollViewActivity extends AppCompatActivity {

    private static final String TAG = "debug_NestedScrollViewActivit";
    private RecyclerView mRecyclerView;
    private ArrayList<String> mStrings = new ArrayList<>();
    private DisplayMetrics mDisplayMetrics;
    private LinearLayout mLl1;
    private NestedScrollView mNestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_view);
        mRecyclerView = findViewById(R.id.rv_list);
        mLl1 = findViewById(R.id.ll_1);
        mNestedScrollView = findViewById(R.id.nsv);


        mDisplayMetrics = getResources().getDisplayMetrics();


        for (int i = 0; i < 50; i++) {
            mStrings.add("item" + i);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MyAdapter(mStrings)); // 先设置高度，后设置数据源
//        mRecyclerView.post(() -> {
//            ViewGroup.LayoutParams layoutParams = mRecyclerView.getLayoutParams();
//            layoutParams.height = mDisplayMetrics.heightPixels;
//            mRecyclerView.setLayoutParams(layoutParams);
//
//
//        });

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<String> mList;

        public MyAdapter(ArrayList<String> list) {
            mList = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, null,false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Log.e(TAG, "onBindViewHolder: position = " + position);
        holder.render(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView mTitle;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                mTitle = itemView.findViewById(R.id.text_view);
            }

            public void render(String o) {
                mTitle.setText(o);
            }
        }


    }
}
