package com.yanftch.review.android.pages.tablayout_viewpager_fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yanftch.review.R;

public class TabFragment1 extends Fragment {
    private TextView mTextView;
    private String TAG = "debug_TabFragment1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_frag_1, container, false);
        Log.e(TAG, "onCreateView: ");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: ");
        String title = getArguments().getString("title");
        mTextView = view.findViewById(R.id.tv_title);
        mTextView.setText(title);
    }

    public static Fragment getInstance(String title) {
        TabFragment1 fragment1 = new TabFragment1();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment1.setArguments(bundle);
        return fragment1;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        isFirstVisible = true;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !hasVisible) {
            Log.e(TAG, "setUserVisibleHint2: isVisibleToUser = " + isVisibleToUser);
            hasVisible = true;
        }

        Log.e(TAG, "setUserVisibleHint: isVisibleToUser = " + isVisibleToUser);
        if (isFirstVisible && isVisibleToUser) {
            Log.e("fragment666-----1", "setUserVisibleHint: isVisibleToUser = " + isVisibleToUser + ", isFirstVisible = " + isFirstVisible);
            isFirstVisible = false;
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged: hidden = " + hidden);
    }

    private boolean isFirstVisible, hasVisible;
}
