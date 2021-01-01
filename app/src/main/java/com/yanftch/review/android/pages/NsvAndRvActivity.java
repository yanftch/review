package com.yanftch.review.android.pages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;

import java.util.ArrayList;

public class NsvAndRvActivity extends AppCompatActivity {
    private static final String TAG = "debug_NsvAndRvActivity";
    private RecyclerView mRecyclerView;
    private NestedScrollView mNestedScrollView;
    private ArrayList<String> mList = new ArrayList<>();
    private MyAdapter mMyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nsv_and_rv);
        for (int i = 0; i < 100; i++) {
            mList.add("item " + i);
        }

        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_list);
        mNestedScrollView = findViewById(R.id.nsv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mMyAdapter = new MyAdapter(mList);
        mRecyclerView.setAdapter(mMyAdapter);

        RecyclerView.ViewHolder viewHolderForAdapterPosition = mRecyclerView.findViewHolderForAdapterPosition(20);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e(TAG, "onScrollStateChanged: newState = " + newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e(TAG, "onScrolled: dx = " + dx + ", dy = " + dy);
            }
        });

        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                int rvTop = mRecyclerView.getTop();
                if (mRecyclerView.getLayoutManager() != null) {
                    View childAt = mRecyclerView.getLayoutManager().getChildAt(80);
                    if (childAt != null) {
                        int top = childAt.getTop();
                        mNestedScrollView.smoothScrollTo(0, top + rvTop);
                    }
                }
//                mRecyclerView.smoothScrollToPosition(20);
            }
        });

        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                Log.e(TAG, "onScrollChange: scrollX = " + scrollX + ", scrollY = " + scrollY);
            }
        });

//        mNestedScrollView.post(new Runnable() {
//            @Override
//            public void run() {
//                mNestedScrollView.smoothScrollTo(0, 1000);
//            }
//        });

    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private ArrayList<String> mList;

        public MyAdapter(ArrayList<String> list) {
            mList = list;
        }

        @NonNull
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, null, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
//            Log.e(TAG, "onBindViewHolder: position = " + position);
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
