package com.yanftch.review.android.pages;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yanftch.review.R;
import com.yanftch.review.android.modules.CommonItem;
import com.yanftch.review.android.utils.DateUtil;
import com.yanftch.review.android.utils.ScreenUtils;
import com.yanftch.review.android.view.nested_scrollview.MyNestedScrollViewHeaderScale;

import java.util.ArrayList;
import java.util.List;

public class NestedScrollViewWithScaleHeaderImageActivity extends AppCompatActivity {

    private HorizontalScrollView mHorizontalScrollView;
    MyNestedScrollViewHeaderScale mMyNestedScrollViewHeaderScale;
    private LinearLayout mLinearLayout;
    private LayoutInflater mLayoutInflater;
    private TextView mTvTest;
    private int mTvHeight = 0;
    private static final String TAG = "debug_NestedScrollViewWithSca";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_view_with_scale_header_image);
        initView();
        initHsv();
    }

    private void initHsv() {
        List<CommonItem> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CommonItem item = new CommonItem();
            item.setTitle("title" + i);
            item.setContent("我是内容密密麻麻" + i);
            item.setImage("https://image.ziroom.com/g2m3/M00/D8/F7/ChAZE19gHMKAZ7r_AASR1emysfc147.jpg");
            item.setEndTime(1603174897000L);
            list.add(item);
        }

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int width = screenWidth / 3;
        mLayoutInflater = LayoutInflater.from(this);
        for (int i = 0; i < list.size(); i++) {
            View inflate = mLayoutInflater.inflate(R.layout.item_card_view, null, false);

            if (i == 0 && list.get(i).getEndTime() > 0) {
                ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = ScreenUtils.dp2px(this, 10);

                inflate.setLayoutParams(layoutParams);

                inflate.setTag(i);

                TextView textView = inflate.findViewById(R.id.tv_title);
                TextView tvContent = inflate.findViewById(R.id.tv_content);
                textView.setText(list.get(i).getTitle());
                tvContent.setText(list.get(i).getContent());

                // 倒计时
                TextView tvTime = inflate.findViewById(R.id.tv_time);
                TimerDownView timerDownView = new TimerDownView(10000, 1000);
                timerDownView.setOnTimeListener(new TimerDownView.OnTimeListener() {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        tvTime.setText(DateUtil.secToTime((int) (millisUntilFinished / 1000)));
                    }

                    @Override
                    public void onFinish() {
                        tvTime.setText("");

                        int tag = (int) inflate.getTag();

                        Toast.makeText(NestedScrollViewWithScaleHeaderImageActivity.this, "倒计时结束 tag = " + tag, Toast.LENGTH_SHORT).show();
                        mLinearLayout.removeViewAt(tag);
                    }
                });
                timerDownView.start();
            } else if (i == list.size() - 1) {
                ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = ScreenUtils.dp2px(this, 10);

                inflate.setLayoutParams(layoutParams);

                TextView textView = inflate.findViewById(R.id.tv_title);
                TextView tvContent = inflate.findViewById(R.id.tv_content);
                textView.setText("更多");
                tvContent.setText("更多");
            } else {
                ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = ScreenUtils.dp2px(this, 10);

                inflate.setLayoutParams(layoutParams);

                TextView textView = inflate.findViewById(R.id.tv_title);
                TextView tvContent = inflate.findViewById(R.id.tv_content);
                textView.setText(list.get(i).getTitle());
                tvContent.setText(list.get(i).getContent());
            }

            mLinearLayout.addView(inflate);
        }

        mHorizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int maxScrollX = mHorizontalScrollView.getChildAt(0).getMeasuredWidth() - mHorizontalScrollView.getMeasuredWidth();
                Log.e("debug_NestedScrollViewWithScaleHeaderImageActivity:", "onScrollChange==> " + "maxScrollX = " + maxScrollX + ",,, " + mHorizontalScrollView.getScrollX());
                if (maxScrollX == mHorizontalScrollView.getScrollX()) {
                    Toast.makeText(NestedScrollViewWithScaleHeaderImageActivity.this, "最后了", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    private void initView() {
        mHorizontalScrollView = findViewById(R.id.hsv);
        mLinearLayout = findViewById(R.id.ll_hsv_container);
        mTvTest = findViewById(R.id.tv_test);
        mMyNestedScrollViewHeaderScale = findViewById(R.id.nsv);

        mTvTest.post(new Runnable() {
            @Override
            public void run() {
                int top = mTvTest.getTop();
                mTvHeight = top;

                Log.e(TAG, "initView:  top3 ==== " + top);
            }
        });

        findViewById(R.id.tv1).setOnClickListener(v->{
            mMyNestedScrollViewHeaderScale.scrollTo(0, mTvHeight);
        });

    }


    /**
     * 倒计时类
     */
    static class TimerDownView extends CountDownTimer {

        interface OnTimeListener {
            void onTick(long millisUntilFinished);

            void onFinish();
        }

        private OnTimeListener mOnTimeListener;

        public void setOnTimeListener(OnTimeListener listener) {
            mOnTimeListener = listener;
        }

        public TimerDownView(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if (mOnTimeListener != null)
                mOnTimeListener.onTick(millisUntilFinished);
        }

        @Override
        public void onFinish() {
            if (mOnTimeListener != null)
                mOnTimeListener.onFinish();
        }
    }
}
