package com.yanftch.review.android.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.DialogFragment;

import com.yanftch.review.R;

public class LoadingDialog
        extends DialogFragment implements View.OnClickListener {

    private Dialog mDialog;
    private MyDown mMyDown;

    public LoadingDialog(OnDismissCallback onLoginInforCompleted) {
        mOnLoginInforCompleted = onLoginInforCompleted;
    }

    public interface OnDismissCallback {
        void onCallBack();
    }

    private OnDismissCallback mOnLoginInforCompleted;

    public void setOnLoginInforCompleted(OnDismissCallback onLoginInforCompleted) {
        mOnLoginInforCompleted = onLoginInforCompleted;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // 自定义 style BottomDialog
        mDialog = new Dialog(getActivity(), R.style.BottomDialog);

        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_fragment_loading);

        // 外部点击设置为可以取消
        mDialog.setCanceledOnTouchOutside(true);

        Window window = mDialog.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();

        // 布局属性位于整个窗口底部
        layoutParams.gravity = Gravity.BOTTOM;

        // 布局属性宽度填充满整个窗口宽度，默认是有 margin 值的
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(layoutParams);

        mMyDown = new MyDown(2000, 1000);
        mMyDown.start();



        return mDialog;
    }

    class MyDown extends CountDownTimer {

        public MyDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            mDialog.dismiss();
            mOnLoginInforCompleted.onCallBack();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }
}
