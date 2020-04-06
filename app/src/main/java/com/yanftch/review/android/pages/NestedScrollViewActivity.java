package com.yanftch.review.android.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;

import java.util.ArrayList;

public class NestedScrollViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mStrings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_view);
        mRecyclerView = findViewById(R.id.rv_list);


        for (int i = 0; i < 50; i++) {
            mStrings.add("item" + i);
        }
        mRecyclerView.setAdapter(new MyAdapter(mStrings));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
