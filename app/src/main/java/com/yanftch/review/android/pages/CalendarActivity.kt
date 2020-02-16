package com.yanftch.review.android.pages

import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.UI
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.verticalLayout
import java.util.*


/**
 * Author : yanftch
 * Date   : 2020-02-14
 * Time   : 14:55
 * Desc   : 向系统日历写入日程提醒
 */

class CalendarActivity : AppCompatActivity() {
    private val CALENDER_URL = "content://com.android.calendar/calendars"
    private val CALENDER_EVENT_URL = "content://com.android.calendar/events"
    private val CALENDER_REMINDER_URL = "content://com.android.calendar/reminders"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view())
    }


    fun view() = UI {
        verticalLayout {
            button {
                text = "向日历中写入日程提醒"
                onClick {
                    addCalendarEvent()
                    addCalendarEvent(this@CalendarActivity, "买票","今天去买票",1581664559000,0)
                }
            }
        }
    }.view

    fun addCalendarEvent() {
        val eventID: Long = 221
        val values = ContentValues().apply {
            put(CalendarContract.Reminders.MINUTES, 15)
            put(CalendarContract.Reminders.EVENT_ID, eventID)
            put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT)
        }
//        val uri: Uri = contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, values)

        val intent = Intent(Intent.ACTION_INSERT)
            .setData(CalendarContract.Events.CONTENT_URI)
            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 1581664979000)
            .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 1581665099000)
            .putExtra(CalendarContract.Events.TITLE, "Yoga")
            .putExtra(CalendarContract.Events.DESCRIPTION, "Group class")
            .putExtra(CalendarContract.Events.EVENT_LOCATION, "The gym")
            .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
            .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com")
        startActivity(intent)
    }


    /**
     * 添加日历账户，账户创建成功则返回账户id，否则返回-1
     */
//    private fun addCalendarAccount(context: Context): Long {
//        val timeZone: TimeZone = TimeZone.getDefault()
//        val value = ContentValues()
//        value.put(CalendarContract.Calendars.NAME, CALENDARS_NAME)
//        value.put(CalendarContract.Calendars.ACCOUNT_NAME, CALENDARS_ACCOUNT_NAME)
//        value.put(CalendarContract.Calendars.ACCOUNT_TYPE, CALENDARS_ACCOUNT_TYPE)
//        value.put(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME, CALENDARS_DISPLAY_NAME)
//        value.put(CalendarContract.Calendars.VISIBLE, 1)
//        value.put(CalendarContract.Calendars.CALENDAR_COLOR, Color.BLUE)
//        value.put(
//            CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL,
//            CalendarContract.Calendars.CAL_ACCESS_OWNER
//        )
//        value.put(CalendarContract.Calendars.SYNC_EVENTS, 1)
//        value.put(CalendarContract.Calendars.CALENDAR_TIME_ZONE, timeZone.getID())
//        value.put(CalendarContract.Calendars.OWNER_ACCOUNT, CALENDARS_ACCOUNT_NAME)
//        value.put(CalendarContract.Calendars.CAN_ORGANIZER_RESPOND, 0)
//        var calendarUri: Uri = Uri.parse(CALENDER_URL)
//        calendarUri = calendarUri.buildUpon()
//            .appendQueryParameter(CalendarContract.CALLER_IS_SYNCADAPTER, "true")
//            .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_NAME, CALENDARS_ACCOUNT_NAME)
//            .appendQueryParameter(CalendarContract.Calendars.ACCOUNT_TYPE, CALENDARS_ACCOUNT_TYPE)
//            .build()
//        val result: Uri = context.getContentResolver().insert(calendarUri, value)
//        return if (result == null) -1 else ContentUris.parseId(result)
//    }

    /**
     * 添加日历事件
     */
    fun addCalendarEvent(
        context: Context?,
        title: String?,
        description: String?,
        reminderTime: Long,
        previousDate: Int
    ) {
        if (context == null) {
            return
        }
//        val calId: Int = checkAndAddCalendarAccount(context) //获取日历账户的id
//        if (calId < 0) { //获取账户id失败直接返回，添加日历事件失败
//            return
//        }
        //添加日历事件
        val mCalendar: Calendar = Calendar.getInstance()
        mCalendar.timeInMillis = reminderTime //设置开始时间
        val start: Long = mCalendar.time.time
        mCalendar.timeInMillis = start + 10 * 60 * 1000 //设置终止时间，开始时间加10分钟
        val end: Long = mCalendar.time.time
        val event = ContentValues()
        event.put("title", title)
        event.put("description", description)
        event.put("calendar_id", "test") //插入账户的id
        event.put(CalendarContract.Events.DTSTART, start)
        event.put(CalendarContract.Events.DTEND, end)
        event.put(CalendarContract.Events.HAS_ALARM, 1) //设置有闹钟提醒
        event.put(CalendarContract.Events.EVENT_TIMEZONE, "Asia/Shanghai") //这个是时区，必须有
        val newEvent: Uri =
            context.contentResolver.insert(Uri.parse(CALENDER_EVENT_URL), event)
                ?: //添加日历事件失败直接返回
                return //添加事件
        //事件提醒的设定
        val values = ContentValues()
        values.put(CalendarContract.Reminders.EVENT_ID, ContentUris.parseId(newEvent))
        values.put(CalendarContract.Reminders.MINUTES, 2) // 提前previousDate天有提醒
        values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT)
        val uri: Uri =
            context.contentResolver.insert(Uri.parse(CALENDER_REMINDER_URL), values)
                ?: //添加事件提醒失败直接返回
                return
    }
}
