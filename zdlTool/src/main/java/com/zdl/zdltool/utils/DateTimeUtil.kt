package com.zdl.zdltool.utils

import org.jetbrains.annotations.NotNull
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author zdl
 * date 2019/5/31 10:57
 * email zdl328465042@163.com
 * description 时间日期相关工具类
 */
object DateTimeUtil {

    object DATE_PATTERN{
        const val DATE_PATTERN1 = "yyyy-MM-dd HH:mm:ss"
        const val DATE_PATTERN2 = "yyyy年MM月dd日 HH时mm分ss秒"
        const val DATE_PATTERN3 = "yyyy.MM.dd HH:mm:ss"
    }

    private val calendar = Calendar.getInstance()

    /**
     * 获取年
     */
    fun getYear(): Int = calendar.get(Calendar.YEAR)

    /**
     * 获取月
     */
    fun getMonth(): Int = calendar.get(Calendar.MONTH) + 1

    /**
     * 获取日
     */
    fun getDay(): Int = calendar.get(Calendar.DATE)

    /**
     * 获取时
     */
    fun getHour(): Int = calendar.get(Calendar.HOUR)

    /**
     * 获取分
     */
    fun getMinute(): Int = calendar.get(Calendar.MINUTE)

    /**
     * 获取秒
     */
    fun getSecond(): Int = calendar.get(Calendar.SECOND)

    /**
     * 获取系统时间戳
     * @return time 当前时间，unit:millisecond
     */
    fun getCurrentTime(): Long = System.currentTimeMillis()

    /**
     * 时间戳转换成字符串
     * @param pattern 字符串格式
     * @param time time 目标时间戳，unit:millisecond
     * @return str 日期字符串，字符串格式为pattern
     */
    fun time2str(pattern: String, @NotNull time: Long): String = sdf(pattern).format(Date(time))

    /**
     * 字符串转换为时间戳，需要保持字符串格式一样
     * @param pattern 字符串格式
     * @param str 日期字符串，字符串格式为pattern
     * @return time 时间戳，unit:millisecond
     */
    fun str2time(pattern: String, @NotNull str: String): Long {
        var date = Date()
        try {
            date = sdf(pattern).parse(str)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return date.time
    }

    /**
     * 从Date中获取月份
     * @param date 输入日期
     * @return month
     */
    fun getMonthFromDate(date: Date): Int {
        val cal = Calendar.getInstance()
        cal.time = date
        return cal.get(Calendar.MONTH) + 1
    }

    /**
     * 从日期字符串中获取月份，需要保持字符串格式一样
     * @param pattern 字符串格式
     * @param str 日期字符串，字符串格式为pattern
     * @return month
     */
    fun getMonthFromStr(pattern: String, str: String): Int {
        val cal = Calendar.getInstance()
        cal.timeInMillis = str2time(pattern, str)
        return cal.get(Calendar.MONTH) + 1
    }

    /**
     * 从日期中获取星期几
     * @param date 日期
     * @return 星期几
     */
    fun getWeekFormDate(date: Date): String{
        val cal = Calendar.getInstance()
        cal.time = date
        return when(cal.get(Calendar.DAY_OF_WEEK)){
            2 -> { "星期一" }
            3 -> { "星期二" }
            4 -> { "星期三" }
            5 -> { "星期四" }
            6 -> { "星期五" }
            7 -> { "星期六" }
            else -> { "星期日" }
        }
    }

    /**
     * 获取某年某月的第一天
     * @param pattern 字符串格式
     * @param month 月份
     * @return str 该月第一天的字符串，字符串格式为pattern
     */
    fun getFirstDayFromMonth(pattern: String, year: Int, month: Int): String {
        val cal = Calendar.getInstance()
        cal.set(Calendar.YEAR, year)
        cal.set(Calendar.MONTH, month - 1)
        cal.set(Calendar.DAY_OF_MONTH, 1)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        return sdf(pattern).format(cal.time)
    }

    /**
     * 获取某年某月的最后一天
     * @param pattern 字符串格式
     * @param month 月份
     * @return str 该月最后一天的字符串，字符串格式为pattern
     */
    fun getLastDayFromMonth(pattern: String, year: Int, month: Int): String {
        val cal = Calendar.getInstance()
        cal.set(Calendar.YEAR, year)
        cal.set(Calendar.MONTH, month - 1)
        cal.set(Calendar.HOUR_OF_DAY, 23)
        cal.set(Calendar.MINUTE, 59)
        cal.set(Calendar.SECOND, 59)
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))
        return sdf(pattern).format(cal.time)
    }

    /**
     * 获取前n天日期、后n天日期
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return 日期
     */
    fun getBeforeOrLaterDate(pattern: String, distanceDay: Int): String {
        val beginDate = Date()
        val cal = Calendar.getInstance()
        cal.time = beginDate
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - distanceDay)
        var endDate: Date? = null
        try {
            endDate = sdf(pattern).parse(sdf(pattern).format(cal.time))
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return sdf(pattern).format(endDate)
    }

    /* 为DateTimeUtil服务的方法 */
    private fun sdf(pattern: String): SimpleDateFormat {
        return SimpleDateFormat(pattern, Locale.CHINA)
    }
}