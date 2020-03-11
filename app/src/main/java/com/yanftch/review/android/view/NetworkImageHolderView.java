package com.yanftch.review.android.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.yanftch.review.R;

import org.w3c.dom.Text;

//A、网络图片
public class NetworkImageHolderView implements Holder<String> {
    private ImageView imageView;
    private TextView mTextView;
    private String url = "http://10.16.34.48:8080/group1/M00/18/90/ChAiMF47sWKAHk32AAzodQCbVVc446.jpg";

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner_view, null, false);
        mTextView = view.findViewById(R.id.tv_title);
        //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
        imageView = view.findViewById(R.id.iv_image);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return view;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        mTextView.setText(position + "---------");
        Glide.with(context).load(data).into(imageView);
    }
}