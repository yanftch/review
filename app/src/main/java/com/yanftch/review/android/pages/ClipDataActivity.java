package com.yanftch.review.android.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.yanftch.review.R;
import com.yanftch.review.android.utils.ClipUtils;

public class ClipDataActivity extends AppCompatActivity {
    private static final String TAG = "debug_ClipDataActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_data);

        findViewById(R.id.btn_set).setOnClickListener(v->{
            // 1.复制到剪贴板
            ClipUtils.copyText(this, "[BBB]大家好啊，我是复制的文本内容");
            Toast.makeText(this, "已复制", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btn_get).setOnClickListener(v->{
            ClipUtils.getClipData(getApplicationContext(), clipData -> {
                Log.e(TAG, "onCreate: execute==> 剪贴板内容：" + "" + clipData );
                if (TextUtils.isEmpty(clipData)) {
                    return;
                }

            });
        });

    }
}