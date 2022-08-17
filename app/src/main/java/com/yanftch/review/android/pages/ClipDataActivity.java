package com.yanftch.review.android.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yanftch.review.R;
import com.yanftch.review.android.utils.ClipUtils;
import com.yanftch.review.android.utils.DensityUtil;

public class ClipDataActivity extends AppCompatActivity {
    private static final String TAG = "debug_ClipDataActivity";
    private LinearLayout mLinearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_data);
        mLinearLayout = findViewById(R.id.ll_container);


        findViewById(R.id.btn_set).setOnClickListener(v -> {
            // 1.复制到剪贴板
            ClipUtils.copyText(this, "[BBB]大家好啊，我是复制的文本内容");
            Toast.makeText(this, "已复制", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btn_get).setOnClickListener(v -> {
            ClipUtils.getClipData(getApplicationContext(), clipData -> {
                Log.e(TAG, "onCreate: execute==> 剪贴板内容：" + "" + clipData);
                if (TextUtils.isEmpty(clipData)) {
                    return;
                }

            });
        });

        int size = 10;


    }

//    private View getLineView() {
//
//    }


    /**
    * 获取每个小模块视图
    */
    private View getItemView() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ImageView pvImage = new ImageView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtil.dip2px(this, 52), DensityUtil.dip2px(this, 52));
        pvImage.setLayoutParams(layoutParams);

        TextView tvContent = new TextView(this);
        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvParams.topMargin = DensityUtil.dip2px(this, 6);
        tvContent.setLayoutParams(tvParams);
        tvContent.setText("标题");

        linearLayout.addView(pvImage);
        linearLayout.addView(tvContent);

        pvImage.setImageResource(R.drawable.img_home_388);

        return linearLayout;
    }
}