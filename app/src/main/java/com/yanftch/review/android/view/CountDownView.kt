package com.yanftch.review.android.view

import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.yanftch.review.R

class CountDownView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    companion object {
        /**
         * 输入: 时间戳，毫秒值
         * 一天：24 * 60 * 60 * 1000
         * 一小时：60 * 60 * 1000
         * 一分钟：60 * 1000
         */

        const val DAY = 24 * 60 * 60 * 1000 // 86400 * 1000
        const val HOUR: Long = 60 * 60 * 1000 // 3600 * 1000
        const val MINUTE: Long = 60 * 1000 // 60 * 1000

        // 倒计时步长
        const val INTERVAL: Long = 1000
    }

    private var mProjectId: String = ""
    private var mHouseTypeId: String? = null

    private var mContext: Context = context
    private lateinit var mTimeCount: TimeCount

    // UI
    private var mTvDay: TextView
    private var mTvDaySeparator: TextView

    private var mTvHour: TextView
    private var mTvHourSeparator: TextView

    private var mTvMinute: TextView
    private var mTvMinuteSeparator: TextView

    private var mTvSecond: TextView

    // 倒计时结束后显示的文本内容
    private var mTvEndMessage: TextView
    private var mLlTimeContainer: LinearLayout

    init {
        LayoutInflater.from(mContext).inflate(R.layout.zra_layout_view_countdown, this)
        mTvDay = findViewById(R.id.tv_day)
        mTvDaySeparator = findViewById(R.id.tv_day_separator)
        mTvHour = findViewById(R.id.tv_hour)
        mTvHourSeparator = findViewById(R.id.tv_hour_separator)
        mTvMinute = findViewById(R.id.tv_minute)
        mTvMinuteSeparator = findViewById(R.id.tv_minute_separator)
        mTvSecond = findViewById(R.id.tv_second)
        mTvEndMessage = findViewById(R.id.tv_end_message)
        mLlTimeContainer = findViewById(R.id.ll_time_container)
    }

    @Suppress("unused")
    fun inject(projectId: String, houseTypeId: String?) {
        mProjectId = projectId
        mHouseTypeId = houseTypeId
    }

    /**
     *
     * @param millisecond 毫秒值
     * @param endMessage 倒计时结束后，显示的文本内容
     */
    fun setData(millisecond: Long, endMessage: String?) {
        Log.e(
            "debug_TimeCount:", "millisecond === $millisecond 毫秒, endMessage = $endMessage"
        )
        if (millisecond <= 0) {
            mTvEndMessage.visibility = View.VISIBLE
            mLlTimeContainer.visibility = View.GONE
            mTvEndMessage.text = endMessage
            return
        }
        mTvEndMessage.visibility = View.GONE
        mLlTimeContainer.visibility = View.VISIBLE

        mTimeCount = TimeCount(millisecond, INTERVAL, endMessage)
        mTimeCount.start()
    }

    @Suppress("unused")
    fun stopCountDown() {
        mTimeCount.cancel()
    }

    /**
     * 格式化一位数为两位数
     */
    fun formatUnit(num: Long): String {
        return if (num in 0..9) {
            "0$num"
        } else {
            "$num"
        }
    }

    /**
     * 倒计时类
     */
    inner class TimeCount(total: Long, interval: Long, private var endMessage: String?) :
        CountDownTimer(total, interval) {
        override fun onFinish() {
            Log.e(
                "debug_TimeCount:", "onFinish =====> endMessage = $endMessage"
            )
            mTvEndMessage.visibility = View.VISIBLE
            mLlTimeContainer.visibility = View.GONE
            mTvEndMessage.text = endMessage
        }

        override fun onTick(millisUntilFinished: Long) {
            val day: Long = millisUntilFinished / DAY //单位天

            val hour: Long =
                (millisUntilFinished - day * DAY) / HOUR //单位时

            val minute: Long =
                (millisUntilFinished - day * DAY - hour * HOUR) / MINUTE //单位分

            val second: Long =
                (millisUntilFinished - day * DAY - hour * HOUR - minute * MINUTE) / 1000 //单位秒

            Log.e(
                "debug_TimeCount:",
                "onTick==> day = $day, hour = $hour, minute = $minute, second = $second"
            )
            mTvDay.text = formatUnit(day)
            mTvHour.text = formatUnit(hour)
            mTvMinute.text = formatUnit(minute)
            mTvSecond.text = formatUnit(second)
        }
    }
}