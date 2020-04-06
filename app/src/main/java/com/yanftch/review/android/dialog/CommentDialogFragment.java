package com.yanftch.review.android.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.yanftch.review.R;

public class CommentDialogFragment extends DialogFragment implements View.OnClickListener {

    private Dialog mDialog;
    private EditText commentEditText;

    public interface OnLoginInforCompleted {
        void inputLoginInforCompleted(String userName, String passWord);
    }

    private OnLoginInforCompleted mOnLoginInforCompleted;

    public void setOnLoginInforCompleted(OnLoginInforCompleted onLoginInforCompleted) {
        mOnLoginInforCompleted = onLoginInforCompleted;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // 自定义 style BottomDialog
        mDialog = new Dialog(getActivity(), R.style.BottomDialog);

        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_fragment_comment_layout);

        // 外部点击设置为可以取消
        mDialog.setCanceledOnTouchOutside(true);

        Window window = mDialog.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();

        // 布局属性位于整个窗口底部
        layoutParams.gravity = Gravity.BOTTOM;

        // 布局属性宽度填充满整个窗口宽度，默认是有 margin 值的
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(layoutParams);

        commentEditText = (EditText) mDialog.findViewById(R.id.edit_comment);
        commentEditText.requestFocus();
        commentEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (mOnLoginInforCompleted != null) {
                        mOnLoginInforCompleted.inputLoginInforCompleted("1", "" + v.getText());
                    }
                    dismiss();
                    return true;
            }
        });

        return mDialog;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }
}