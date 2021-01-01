package com.yanftch.review.android.view.calendar_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;
import com.yanftch.review.android.modules.PriceBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SuppressLint("LongLogTag")

public class CalendarViewAdapter extends RecyclerView.Adapter<CalendarViewAdapter.CalendarViewHolder> {

    private static final String TAG = "debug_CalendarViewAdapter";

    private Context mContext;

    // 每月第一天前边的空格数量
    private int mEmptyCount = 0;

    // 用 Calendar 作为 RV 的数据源
    private Calendar mCalRvData;
    private List<PriceBean> mList = new ArrayList<>();

    private LayoutInflater mLayoutInflater;

    private OnCalendarItemClick mOnCalendarItemClick;

    private SimpleDateFormat mDateFormat;

    // TODO:yanfeng 2020-11-24 目前采取的是用当天作为入住日！！！ 模拟的数据
    private Date mToday;

    // 选中的索引值
//    private int mSelectedPosition = -1;

    // 记录已经选中 哪一天
    private Calendar mSelectedCalendar;

    // 可入住时间
    private String mInLiveDayString = "2020-11-20";

    private SimpleDateFormat mSmfLiveDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    /**
     * 获取可入住的时间 Date
     */
    @Nullable
    private Date getLiveDayDate() {
        try {
            return mSmfLiveDate.parse(mInLiveDayString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void setOnCalendarItemClick(OnCalendarItemClick onCalendarItemClick) {
        mOnCalendarItemClick = onCalendarItemClick;
    }

    public CalendarViewAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        mToday = new Date();
    }

    public interface OnCalendarItemClick {
        void onItemClick(Calendar calendar, int position, PriceBean priceBean);
    }

    public Calendar getCalendar() {
        return mCalRvData;
    }

    public void setData(Calendar calendar) {
        setData(calendar, new ArrayList<>());
    }

    public void setData(Calendar calendar, List<PriceBean> list) {
        mCalRvData = calendar;
        mList = list;
//        mSelectedPosition = -1; // 每次切换月份，需要将选中的索引值清除
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CalendarViewHolder(mLayoutInflater.inflate(R.layout.item_rv_calendar_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.render(mCalRvData, position);
    }

    @Override
    public int getItemCount() {
        return getDays();
    }

    private int getDays() {
        if (mCalRvData == null) return 0;

        mCalRvData.set(Calendar.DATE, 1); //
        mEmptyCount = mCalRvData.get(Calendar.DAY_OF_WEEK) - 1;
        mCalRvData.roll(Calendar.DATE, -1);
        int dateCount = mCalRvData.get(Calendar.DATE);

//        Log.e(TAG, "getDays: " + (mCalRvData.getActualMaximum(Calendar.DAY_OF_MONTH) + mEmptyCount) + "===" + (dateCount + mEmptyCount));
        return dateCount + mEmptyCount;
    }

    class CalendarViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvDay;
        private TextView mTvPrice;
        private View mRootView;
        private TextView mTvInDay;
        private TextView mTvTips;

        CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvDay = itemView.findViewById(R.id.tv_day);
            mTvPrice = itemView.findViewById(R.id.tv_price);
            mRootView = itemView.findViewById(R.id.ll_container);
            mTvInDay = itemView.findViewById(R.id.tv_in_day);
            mTvTips = itemView.findViewById(R.id.tv_tips);
        }

        void render(Calendar calendar, int position) {
            if (position < mEmptyCount) {
                // 月份的开始空白天数，显示空白
                mTvInDay.setVisibility(View.GONE);
                mTvDay.setVisibility(View.GONE);
                mTvPrice.setVisibility(View.GONE);
                mTvTips.setVisibility(View.GONE);
                mRootView.setOnClickListener(null);
                mRootView.setBackground(null);
            } else {
                // 传入的集合的真实索引值
                int listPosition = position - mEmptyCount;
                mTvDay.setText(String.valueOf(position + 1 - mEmptyCount));
                calendar.set(Calendar.DATE, position + 1 - mEmptyCount);

                String format = mDateFormat.format(calendar.getTime());
//                Log.e(TAG, "render: " + calendar.getTime());

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int day = calendar.get(Calendar.DATE);

//                mTvPrice.setText(format);

                // 今天
//                if (mDateFormat.format(mToday).equals(format)) {
//                    mRootView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.black_200));
//                    mRootView.setBackgroundResource(R.drawable.bg_rectangle_ff961e_radius_2);
//                }

//                Log.e(TAG, "render: position = " + position + ", listPosition = " + listPosition + ", mList.size = " + mList.size());

                if (mList != null && !mList.isEmpty()) {
                    // 价格
                    if (listPosition < mList.size() && mList.get(listPosition) != null) { // 要确保 listPosition 在 mList 的索引值范围内
                        double price = mList.get(listPosition).getPrice();
                        mTvPrice.setText(String.format("￥%s/月", price));
                    }
                }

                // 显示入住日
                mTvInDay.setText("入住日");
                mTvTips.setText("低价");

                // 处理可入住文案显示&字体颜色
                if (TextUtils.equals(mInLiveDayString, format)) {
                    mTvInDay.setText("可入住");
                    mTvInDay.setTextColor(ContextCompat.getColor(mContext, R.color.color_ct4));
                } else {
                    mTvInDay.setText("");
                }

//                Log.e(TAG, "render: render===== mList.get() = ======== " + mList.get(listPosition));

                // 小于当前日期的，颜色特殊处理一下
                if (calendar.getTime().getTime() < mToday.getTime()) {
                    mTvDay.setTextColor(ContextCompat.getColor(mContext, R.color.color_ct1_40));
                    mTvInDay.setVisibility(View.INVISIBLE);
                    mTvPrice.setVisibility(View.INVISIBLE);
                    mTvTips.setVisibility(View.INVISIBLE);
                } else {
                    if (mList != null && !mList.isEmpty() && listPosition < mList.size()) {
                        PriceBean priceBean = mList.get(listPosition);
                        if (priceBean.isLowPrice()) {
                            mTvPrice.setTextColor(ContextCompat.getColor(mContext, R.color.color_ct3));
                            mTvTips.setTextColor(ContextCompat.getColor(mContext, R.color.color_ct3));
                        } else {
                            mTvPrice.setTextColor(ContextCompat.getColor(mContext, R.color.color_ct1_40));
                            mTvTips.setVisibility(View.INVISIBLE);
                        }
                    } else {
                        mTvPrice.setVisibility(View.INVISIBLE);
                        mTvTips.setVisibility(View.INVISIBLE);
                    }
                }

//                Log.e(TAG, "render: render===== calendar = ======== " + getText(calendar));
//                Log.e(TAG, "render: render===== mSelectedCalendar = " + getText(mSelectedCalendar));

                // 选中状态
                if (mSelectedCalendar != null) {
                    if (mSelectedCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
                            && mSelectedCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
                            && mSelectedCalendar.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {
                        Log.e(TAG, "render: position ===== " + position + "     " + (position + 1 - mEmptyCount));
                        mRootView.setBackgroundResource(R.drawable.bg_rectangle_c4_radius_4);
                        mTvInDay.setTextColor(ContextCompat.getColor(mContext, R.color.color_ct2));
                        mTvDay.setTextColor(ContextCompat.getColor(mContext, R.color.color_ct2));
                        mTvPrice.setTextColor(ContextCompat.getColor(mContext, R.color.color_ct2));
                        mTvTips.setTextColor(ContextCompat.getColor(mContext, R.color.color_ct2));

                        mTvInDay.setText("入住日");
                    } else {
                        mRootView.setBackground(null);
                    }
                }

                // 周末颜色特殊处理---不需要特殊处理颜色
//                if (position % 7 == 0 || position % 7 == 6) {
//                    mTvDay.setTextColor(ContextCompat.getColor(mContext, R.color.black_700));
//                }

                mRootView.setOnClickListener(v -> {
                    calendar.set(Calendar.DATE, position + 1 - mEmptyCount);

                    // 如果已经过了 入住日 的时间，就不能点击&置灰处理
                    if (calendar.getTime().getTime() < mToday.getTime()) {
                        // 已过时间，不能点击，置灰处理

                        return;
                    }

                    // 记录选中的 日期
                    mSelectedCalendar = Calendar.getInstance();
                    mSelectedCalendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
                    mSelectedCalendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
                    mSelectedCalendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));

                    Date time = calendar.getTime();

                    Log.e(TAG, "render: setOnClickListener===== calendar = ======== " + getText(calendar));
                    Log.e(TAG, "render: setOnClickListener===== mSelectedCalendar = " + getText(mSelectedCalendar));
                    Log.e(TAG, "render: =======================================================================");


//                    Toast.makeText(mContext, "format " + format + ", ", Toast.LENGTH_SHORT).show();

                    if (mOnCalendarItemClick != null && listPosition < mList.size()) {
                        mOnCalendarItemClick.onItemClick(calendar, listPosition, mList.get(listPosition));
                    }

//                    mSelectedPosition = position;
                    notifyDataSetChanged();

                });
            }
        }

        private String getText(Calendar calendar) {
            if (calendar == null) return "";
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DATE);
            int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取一个月共几天
            return year + "年" + month + "月" + day + "日";
        }
    }

}
