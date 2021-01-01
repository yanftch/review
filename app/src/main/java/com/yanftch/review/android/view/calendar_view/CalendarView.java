package com.yanftch.review.android.view.calendar_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanftch.review.R;
import com.yanftch.review.android.modules.PriceBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 日历控件
 */
public class CalendarView extends LinearLayout {
    private static final String TAG = "debug_CalendarView";

    private LayoutInflater mLayoutInflater;
    private CalendarViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private OnCalendarItemClick mOnCalendarItemClick;
    private TextView mTvCurrentMonth;
    private ImageView mBtnBefore, mBtnAfter;
    private Context mContext;

    // 记录最小月份，低于这个月份的就不能加载显示了
    private int mMinMonth = -1;

    private OnButtonClickListener mOnButtonClickListener;

    public interface OnButtonClickListener {
        void onBeforeClick(Calendar calendar);

        void onAfterClick(Calendar calendar);
    }

    public CalendarView(Context context) {
        this(context, null);
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO:yanfeng 2020-11-24 此处假装当前月份就是最小月份
        int i = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int y = Calendar.getInstance().get(Calendar.YEAR);

        mMinMonth = i;
        mContext = context;
        mMaxCalendar = Calendar.getInstance();
        mMaxCalendar.add(Calendar.MONTH, 11);
        mSubMaxCalendar = Calendar.getInstance();
        mSubMaxCalendar.set(Calendar.YEAR, mMaxCalendar.get(Calendar.YEAR));
        mSubMaxCalendar.set(Calendar.MONTH, mMaxCalendar.get(Calendar.MONTH) -1 );

        Log.e(TAG, "CalendarView: mMinCalendar = " + getCalenderInfo(mMinCalendar) + ", mMaxCalendar = " + getCalenderInfo(mMaxCalendar));
        init(context);
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        mOnButtonClickListener = listener;
    }


    // TODO:yanfeng 2020-11-30 最大 12 个月可以，往上选择的
    int mMaxMonthCount = 12;
    int mMonthAddCount = 0;
    Calendar mMinCalendar = Calendar.getInstance();
    Calendar mMaxCalendar;
    Calendar mSubMaxCalendar;


    private void init(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mLayoutInflater.inflate(R.layout.layout_item_calendar_view, this, true);

        mTvCurrentMonth = findViewById(R.id.tv_current_month);
        mBtnBefore = findViewById(R.id.btn_before);
        mBtnAfter = findViewById(R.id.btn_after);

        mRecyclerView = findViewById(R.id.rv_date);

        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 7));

        mAdapter = new CalendarViewAdapter(context);
        mRecyclerView.setAdapter(mAdapter);

        mBtnBefore.setOnClickListener(v -> {
            if (mAdapter == null) return;
            Calendar calendar = mAdapter.getCalendar();

            /**
             * 默认，进来，calendar 是 2020 年 11月，然后点击减少，
             * mMinCalendar 是 2020 年 11 月
             *
             * 然后点击增加，此时 calendar 变成了额 2020-12，mMinCalendar 还是 2020-11，此时再点击减少，
             */

            Log.e(TAG, "init:  mBtnBefore   mMinCalendar = " + getCalenderInfo(mMinCalendar) + ", start(calendar) = " + getCalenderInfo(calendar));
            boolean b = !compareCalendar(calendar, mMinCalendar);
            if (b) {
                Toast.makeText(mContext, "年份。。。太小了，不能点了", Toast.LENGTH_SHORT).show();
                return;
            }


//            Date time = calendar.getTime();
//            int i = timeCompareByDate(mMinDate, time);
//            if (i == COMPARE_1 || i == COMPARE_2) {
//                Toast.makeText(mContext, "年份。。。太小了，不能点了", Toast.LENGTH_SHORT).show();
//                return;
//            }

//            int lYear = calendar.get(Calendar.YEAR);
//            int lMonth = calendar.get(Calendar.MONTH) + 1;
//
//            if (mMinYear > lYear) {
//                Toast.makeText(mContext, "年份。。。太小了，不能点了", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            if (mMinMonth > lMonth) {
//                Toast.makeText(mContext, "太小了，不能点了", Toast.LENGTH_SHORT).show();
//                return;
//            }
            calendar.add(Calendar.MONTH, -1);


            if (mOnButtonClickListener != null) {
                mOnButtonClickListener.onBeforeClick(calendar);
            }
        });


        mBtnAfter.setOnClickListener(v -> {

            if (mAdapter == null) return;
//            Log.e(TAG, "init: mBtnAfter   mMonthAddCount = " + mMonthAddCount);
//
//            if (mMonthAddCount >= mMaxMonthCount) {
//                Toast.makeText(context, "最多选择" + mMaxMonthCount + "个月", Toast.LENGTH_SHORT).show();
//                return;
//            } else {
//                mMonthAddCount++;
//            }


            Calendar calendar = mAdapter.getCalendar();
            Log.e(TAG, "init: mBtnAfter ==== calender = " + getCalenderInfo(calendar));

            Log.e(TAG, "init: mBtnAfter ==== mMaxCalendar = " + getCalenderInfo(mMaxCalendar));
            Log.e(TAG, "init: mBtnAfter ==== mSubMaxCalendar = " + getCalenderInfo(mSubMaxCalendar));

            boolean bMax = compareCalendar(calendar, mSubMaxCalendar);
            if (bMax) {
                mBtnAfter.setImageResource(R.drawable.arrow_down);
            } else {
                mBtnAfter.setImageResource(R.drawable.arrowright);
            }


            boolean b = compareCalendar(calendar, mMaxCalendar);
            if (b) {
                Toast.makeText(context, "做多查看12个月呦~", Toast.LENGTH_SHORT).show();
                return;
            }

//            Date time = calendar.getTime();
//            int i = timeCompareByDate(mMinDate, time);
//            if (i == COMPARE_1 || i == COMPARE_2) {
//                Toast.makeText(mContext, "年份。。。太da了，不能点了", Toast.LENGTH_SHORT).show();
//                return;
//            }


//            int lYear = calendar.get(Calendar.YEAR);
//            int lMonth = calendar.get(Calendar.MONTH) + 1;
//
//            if (mMinYear > lYear) {
//                Toast.makeText(mContext, "年份。。。太小了，不能点了", Toast.LENGTH_SHORT).show();
//                return;
//            }


            // TODO:yanfeng 2020-11-30 需要判断12个月之后就不能点击了吗？

//            if (mMinMonth > lMonth) {
//                Toast.makeText(mContext, "太小了，不能点了", Toast.LENGTH_SHORT).show();
//                return;
//            }

            calendar.add(Calendar.MONTH, 1);

//            boolean b = compareCalendar(calendar, mMinCalendar);
//            if (b) {
//                Toast.makeText(mContext, "年份。。。太小了，不能点了", Toast.LENGTH_SHORT).show();
//                return;
//            }


            if (mOnButtonClickListener != null) {
                mOnButtonClickListener.onAfterClick(calendar);
            }
        });
    }

    private void changeMonth(boolean add) {

        if (mAdapter == null) return;
        Calendar calendar = mAdapter.getCalendar();
        int lMonth = calendar.get(Calendar.MONTH);

        if (mMinMonth > lMonth) {
            Toast.makeText(mContext, "太小了，不能点了", Toast.LENGTH_SHORT).show();
            return;
        }
        calendar.add(Calendar.MONTH, add ? 1 : -1);


        // TODO:yanfeng 2020-11-20 测试代码，每次切换月份的时候，需要将即将切换到的月份的金额集合传递到adapter里边
        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar lCalendar = calendar;
        int month = lCalendar.get(Calendar.MONTH) + 1;
        List<PriceBean> mList = new ArrayList<>();
        int daysOfMonth = lCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取一个月共几天
        int todayDay = lCalendar.get(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < daysOfMonth; i++) {
            PriceBean priceBean = new PriceBean();
            priceBean.setPrice(month + i + 1);
            lCalendar.set(Calendar.DAY_OF_MONTH, i + 1);

//            if (i == todayDay || i - 1 == todayDay || i - 2 == todayDay) {
//                priceBean.setLowPrice(true);
//            }

//            Log.e(TAG, "onCreate: i1 === " + i1);
//            printData(mCalendar,"");
            String format = mDateFormat.format(lCalendar.getTime());
            priceBean.setTimeStr(format);
            mList.add(priceBean);
        }
        setData(calendar, mList);
    }

    private void showMonthText(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        mTvCurrentMonth.setText(String.format(Locale.getDefault(), "%d年%s月", year, getMonthNum(month)));
    }

    public void setData(Calendar calendar) {
        setData(calendar, new ArrayList<>());
    }

    private List<PriceBean> mCurrentMonthPriceList = new ArrayList<>();


    public void setData(Calendar calendar, List<PriceBean> list) {
        if (list != null && !list.isEmpty()) {
            mCurrentMonthPriceList = list;
        }


        boolean b = !compareCalendar(calendar, mMinCalendar);
        if (b) {
            mBtnBefore.setImageResource(R.drawable.arrow_down);
        } else {
            mBtnBefore.setImageResource(R.drawable.arrowleft);
        }

        showMonthText(calendar);
        mAdapter.setData(calendar, list);
        mAdapter.setOnCalendarItemClick((calendar1, position, priceBean) -> {
            if (mOnCalendarItemClick != null) {
                mOnCalendarItemClick.onItemClick(calendar1, position, priceBean);
            }
        });
    }

    public void setOnCalendarItemClick(OnCalendarItemClick onCalendarItemClick) {
        mOnCalendarItemClick = onCalendarItemClick;
    }

    public interface OnCalendarItemClick {
        void onItemClick(Calendar calendar, int position, PriceBean priceBean);
    }

    private String getMonthNum(int month) {
        String s = "";
        switch (month) {
            case 1:
                s = "一";
                break;
            case 2:
                s = "二";
                break;
            case 3:
                s = "三";
                break;
            case 4:
                s = "四";
                break;
            case 5:
                s = "五";
                break;
            case 6:
                s = "六";
                break;
            case 7:
                s = "七";
                break;
            case 8:
                s = "八";
                break;
            case 9:
                s = "九";
                break;
            case 10:
                s = "十";
                break;
            case 11:
                s = "十一";
                break;
            case 12:
                s = "十二";
                break;
        }
        return s;
    }


    /**
     * 判断两个 2020-11-11 格式的日期的大小
     */
    public int timeCompare(String startTime, String endTime) {
        int i = 0;
        // 注意：传过来的时间格式必须要和这里填入的时间格式相同
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            // 开始时间
            Date date1 = dateFormat.parse(startTime);
            // 结束时间
            Date date2 = dateFormat.parse(endTime);
            // 1 结束时间小于开始时间 2 开始时间与结束时间相同 3 结束时间大于开始时间
            if (date2.getTime() < date1.getTime()) {
                //结束时间小于开始时间
                i = COMPARE_1;
            } else if (date2.getTime() == date1.getTime()) {
                //开始时间与结束时间相同
                i = COMPARE_2;
            } else if (date2.getTime() > date1.getTime()) {
                //结束时间大于开始时间
                i = COMPARE_3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public int timeCompareByDate(Date startTime, Date endTime) {
        int i = 0;
        // 注意：传过来的时间格式必须要和这里填入的时间格式相同
        try {
            // 1 结束时间小于开始时间 2 开始时间与结束时间相同 3 结束时间大于开始时间
            if (endTime.getTime() < startTime.getTime()) {
                //结束时间小于开始时间
                i = COMPARE_1;
            } else if (endTime.getTime() == startTime.getTime()) {
                //开始时间与结束时间相同
                i = COMPARE_2;
            } else if (endTime.getTime() > startTime.getTime()) {
                //结束时间大于开始时间
                i = COMPARE_3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 比较两个 Calendar 大小，TRUE-表示开始时间大于结束时间
     */
    private boolean compareCalendar(Calendar start, Calendar end) {
        boolean b = false;

        int startYear = start.get(Calendar.YEAR);
        int endYear = end.get(Calendar.YEAR);

        int startMonth = start.get(Calendar.MONTH) + 1;
        int endMonth = end.get(Calendar.MONTH) + 1;
        if (startYear > endYear) { // 开始年，大于 结束年，则表示可以减小月份，需要返回TRUE
            b = true;
        } else if (startYear == endYear) {
            if (startMonth < endMonth) {
                b = false;
            } else if (startMonth == endMonth) {
                b = false;
            } else {
                b = true;
            }
        } else if (startYear < endYear) {
            b = false;
        }
        return b;
    }

    private final int COMPARE_1 = 1;
    private final int COMPARE_2 = 2;
    private final int COMPARE_3 = 3;


    private String getCalenderInfo(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        return year + "年" + month + "月" + day + "日";
    }

}
