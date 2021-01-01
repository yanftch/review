package com.yanftch.review.android.view;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.yanftch.review.R;

public class InputDialogFragment extends DialogFragment {
    private static final String TAG = "debug_InputDialogFragment";

    private EditText mEtInput;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.item_layout_input_dialog, null, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mEtInput = inflate.findViewById(R.id.et_input);
        mEtInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String s = mEtInput.getText().toString();
                Log.e(TAG, "onEditorAction: s = " + s);
                return false;
            }
        });
    }
}
