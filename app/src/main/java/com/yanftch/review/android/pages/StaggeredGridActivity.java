package com.yanftch.review.android.pages;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.yanftch.review.R;
import com.yanftch.review.android.view.ZraFeedDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private List<String> mList;
    private float mDensity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mDensity = displayMetrics.density;
        initView();

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_list);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        mList = new ArrayList<>();
        mList.add("https://bnbimg.ziroom.com/b8b44be8-9021-4900-82cb-aca612ee3aa1.jpg");
        mList.add("https://bnbimg.ziroom.com/0e57fb01-093a-4fbb-8564-9ebaa8242171.jpg");
        mList.add("https://bnbimg.ziroom.com/f1a5681e-4029-42b1-8a58-65d138261097.png");
        mList.add("https://bnbimg.ziroom.com/e4f656da-12c3-42f8-9752-82262941be34.jpeg");
        mList.add("https://bnbimg.ziroom.com/39103ecd-a02b-4c71-910d-6ba8a243751a.jpeg");
        mList.add("https://bnbimg.ziroom.com/89dcab97-3a21-49c1-a223-0a02c64fcd76.jpg");
        mList.add("https://bnbimg.ziroom.com/9445a99c-b731-48d1-98e3-5aacc443ea31.jpg");
        mList.add("https://bnbimg.ziroom.com/a4fb1d84-1e86-41ed-8a99-70ef14fee787.jpeg");
        mList.add("https://bnbimg.ziroom.com/d0123fc8-01f3-466d-80d4-4864f2a69763.jpeg");
        mMyAdapter = new MyAdapter(mList);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.setAdapter(mMyAdapter);
        mRecyclerView.addItemDecoration(new ZraFeedDividerItemDecoration(mDensity));
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private List<String> mList;

        public MyAdapter(List<String> list) {
            mList = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_stagg, null, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            String s = mList.get(position);
            Glide.with(StaggeredGridActivity.this).load(s).into(holder.mImageView);

            holder.mImageView.setOnClickListener(v -> {

                int[] location = new int[2];
                holder.mImageView.getLocationOnScreen(location);
                int x = location[0];
                int y = location[1];
                int width = holder.mImageView.getWidth();
                int height = holder.mImageView.getHeight();

                Log.e("debug_MyAdapter:", "onBindViewHolder==> " + "x = " + location[0] + ", y = " + location[1] + ", width = " + width + ", height = " + height);

                PhotoViewActivity.startActivity(StaggeredGridActivity.this, s, x, y, width, height);
            });

        }

        @Override
        public int getItemCount() {
            return mList == null ? 0 : mList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private ImageView mImageView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                mImageView = itemView.findViewById(R.id.iv_image);
            }
        }
    }
}
