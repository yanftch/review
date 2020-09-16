package com.yanftch.review.android.pages.smartrefreshlayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;

import java.util.ArrayList;

class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.MyViewHolder> {
    private static final String TAG = "debug_CommonAdapter";

    private ArrayList<String> mList;

    public CommonAdapter(ArrayList<String> list) {
        mList = list;
    }

    public void setData(ArrayList<String> list) {
        if (list == null)return;
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void appendData(ArrayList<String> newList) {
        if (newList == null) return;
        mList.addAll(newList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommonAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommonAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommonAdapter.MyViewHolder holder, int position) {
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