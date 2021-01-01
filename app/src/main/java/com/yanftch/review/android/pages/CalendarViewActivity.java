package com.yanftch.review.android.pages;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yanftch.review.R;
import com.yanftch.review.android.modules.PriceBean;
import com.yanftch.review.android.view.calendar_view.CalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


@SuppressLint("LongLogTag")
public class CalendarViewActivity extends AppCompatActivity implements View.OnClickListener {
    private Calendar mCalendar;
    private static final String TAG = "debug_CalendarViewActivity";

    private CalendarView mCalendarView;
    private List<PriceBean> mList = new ArrayList<>();
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());


    /**
     * 考虑性能，每次接口请求回来三个月的价格集合(当前月)
     */
    private List<PriceBean> mThreePriceList = new ArrayList<>();

    private List<PriceBean> getDatasByMonth(Calendar calendar) {
        List<PriceBean> list = new ArrayList<>();

        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        int month = calendar.get(Calendar.MONTH) + 1;
        int daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取一个月共几天

        for (int i = 0; i < daysOfMonth; i++) {
            PriceBean priceBean = new PriceBean();
            priceBean.setPrice(month + i + 1);
            calendar.set(Calendar.DAY_OF_MONTH, i + 1);
            String format = mDateFormat.format(calendar.getTime());
            priceBean.setTimeStr(format);
            list.add(priceBean);
        }

        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canander_view);


        mCalendar = Calendar.getInstance();


        // 初始化加载，获取当前月的价格日历？
        mList.addAll(getDatasByMonth(mCalendar));

        printData(mCalendar, "");

        mCalendarView = findViewById(R.id.calendar_view);
        mCalendarView.setData(mCalendar, mList);

        mCalendarView.setOnButtonClickListener(new CalendarView.OnButtonClickListener() {
            @Override
            public void onBeforeClick(Calendar calendar) {
                Log.e(TAG, "onBeforeClick: 减少一个月之后的月份是：" + getCalenderInfo(calendar));

                // 如果能查看上一个月的价格日历，则请求上一个月的接口获取价格日历
                List<PriceBean> datasByMonth = getDatasByMonth(calendar);


//                // TODO:yanfeng 2020-11-20 测试代码，每次切换月份的时候，需要将即将切换到的月份的金额集合传递到adapter里边
//                SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//                Calendar lCalendar = calendar;
//                int month = lCalendar.get(Calendar.MONTH) + 1;
//                List<PriceBean> mList = new ArrayList<>();
//                int daysOfMonth = lCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取一个月共几天
//                int todayDay = lCalendar.get(Calendar.DAY_OF_MONTH);
//
//                for (int i = 0; i < daysOfMonth; i++) {
//                    PriceBean priceBean = new PriceBean();
//                    priceBean.setPrice(month + i + 1);
//                    lCalendar.set(Calendar.DAY_OF_MONTH, i + 1);
//
////            if (i == todayDay || i - 1 == todayDay || i - 2 == todayDay) {
////                priceBean.setLowPrice(true);
////            }
//
////            Log.e(TAG, "onCreate: i1 === " + i1);
////            printData(mCalendar,"");
//                    String format = mDateFormat.format(lCalendar.getTime());
//                    priceBean.setTimeStr(format);
//                    mList.add(priceBean);
//                }

                mCalendarView.setData(calendar, datasByMonth);
            }

            @Override
            public void onAfterClick(Calendar calendar) {
                Log.e(TAG, "onAfterClick: 增加一个月之后的月份是：" + getCalenderInfo(calendar));

                // 如果能查看下一个月的价格日历，则请求下一个月的接口获取价格日历
                List<PriceBean> datasByMonth = getDatasByMonth(calendar);



//                // TODO:yanfeng 2020-11-20 测试代码，每次切换月份的时候，需要将即将切换到的月份的金额集合传递到adapter里边
//                SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//                Calendar lCalendar = calendar;
//                int month = lCalendar.get(Calendar.MONTH) + 1;
//                List<PriceBean> mList = new ArrayList<>();
//                int daysOfMonth = lCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取一个月共几天
//                int todayDay = lCalendar.get(Calendar.DAY_OF_MONTH);
//
//                for (int i = 0; i < daysOfMonth; i++) {
//                    PriceBean priceBean = new PriceBean();
//                    priceBean.setPrice(month + i + 1);
//                    lCalendar.set(Calendar.DAY_OF_MONTH, i + 1);
//
////            if (i == todayDay || i - 1 == todayDay || i - 2 == todayDay) {
////                priceBean.setLowPrice(true);
////            }
//
////            Log.e(TAG, "onCreate: i1 === " + i1);
////            printData(mCalendar,"");
//                    String format = mDateFormat.format(lCalendar.getTime());
//                    priceBean.setTimeStr(format);
//                    mList.add(priceBean);
//                }

                mCalendarView.setData(calendar, datasByMonth);

            }
        });
        mCalendarView.setOnCalendarItemClick(new CalendarView.OnCalendarItemClick() {
            @Override
            public void onItemClick(Calendar calendar, int position, PriceBean priceBean) {
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int day = calendar.get(Calendar.DATE);

                String text = year + "-" + month + "-" + day;
                Toast.makeText(CalendarViewActivity.this, "date: " + text + ", position = " + position + ", priceBean = " + priceBean, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
    }

    private String getCalenderInfo(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        return year + "年" + month + "月" + day + "日";
    }

    private void printData(Calendar calendar, String text) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取一个月共几天
//        mCalendar.roll();
        Log.e(TAG, "printData: calendar = text = " + text + "..." + year + "年" + month + "月" + day + "日" + ", 本月共：" + dayOfMonth + "天, " + "\r\n" + calendar);
    }
}
