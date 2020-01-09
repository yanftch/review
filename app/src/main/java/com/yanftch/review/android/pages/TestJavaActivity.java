package com.yanftch.review.android.pages;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.appcompat.app.AppCompatActivity;

import com.yanftch.review.R;
import com.yanftch.review.kotlinbasic.InnerClassDemo;

import java.lang.ref.WeakReference;

public class TestJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_java);
        InnerClassDemo.Companion.getNAME();


    }

    private static class MyHandler extends Handler {
        private WeakReference<Context> mContextWf;

        public MyHandler(Context context) {
            this.mContextWf = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }
}
