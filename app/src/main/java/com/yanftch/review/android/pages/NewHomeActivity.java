package com.yanftch.review.android.pages;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.yanftch.review.R;
import com.yanftch.review.android.fragment.new_home.ZraMainFragment;

public class NewHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_home);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ZraMainFragment mainFragment = ZraMainFragment.newInstance("1", "2");
        fragmentTransaction.add(R.id.cl_container, mainFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }
}