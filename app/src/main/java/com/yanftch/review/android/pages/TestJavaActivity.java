package com.yanftch.review.android.pages;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yanftch.review.R;

public class TestJavaActivity extends AppCompatActivity {
    private Button mButton, mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_java);
        mButton = findViewById(R.id.btn1);
        mButton2 = findViewById(R.id.btn2);

        mButton.setOnClickListener(v -> {
            getStringInfo(null);
        });
        mButton2.setOnClickListener(v -> {
            getStringInfo("2");
        });

    }

    private void getStringInfo(String message) {
        switch (message) {
            case "1":
                Toast.makeText(this, "message = " + message, Toast.LENGTH_SHORT).show();
                break;
            case "2":
                Toast.makeText(this, "message case 2= " + message, Toast.LENGTH_SHORT).show();
                break;
            case "3":
                Toast.makeText(this, "message case 3= " + message, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
