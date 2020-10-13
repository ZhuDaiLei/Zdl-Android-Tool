package com.zdl.zdltool.utils

import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

/**
 * @author zdl
 * date 2019/6/18 17:38
 * email zdl328465042@163.com
 * description 数字相关工具类
 */
object NumberUtil {

    private val sizeTable = arrayOf(9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Int.MAX_VALUE)

    /**
     * 判断有几位，例如：1314，返回4
     * @param num 需要判断的整数
     * @return 位数
     */
    fun sizeOfInt(num: Int): Int {
        var i = 0
        while (true) {
            if (num <= sizeTable[i]) {
                return i + 1
            }
            i++
        }
    }

    /**
     * 十进制转十六进制
     */
    fun int2hex(num: Int): String {
        var s = Integer.toHexString(num).toUpperCase(Locale.CHINA)
        if (s.length == 1) {
            s = "0$s"
        }
        return s
    }

    /**
     * 十六进制转十进制
     */
    fun hex2int(hex: String): Int {
        return Integer.parseInt(hex, 16)
    }

    /**
     * 保留2位数小数，四舍五入
     * @param num 数据源，double、float
     * @param pattern 格式化规则，例如"0.00","#.##"
     * @return String
     */
    fun reserveDecimal(num: Any, pattern: String): String {
        val df = DecimalFormat(pattern)
        return df.format(num)
    }

    /**
     * double类型，保留几位小数
     * @param num  double类型的数据源
     * @param size 保留几位小数
     * @param roundingMode 舍弃小数的方式:ROUND_DOWN去尾,ROUND_UP收尾,ROUND_HALF_UP四舍五入
     * @return String
     */
    fun reserveDecimalMode(@NotNull num: Double, @NotNull size: Int, roundingMode: Int = BigDecimal.ROUND_HALF_UP): String {
        val bd = BigDecimal(num)
        return bd.setScale(size, roundingMode).toEngineeringString()
    }

    /**
     * 获取小数位数
     * @param num 数字字符串
     * @return 小数位数
     */
    fun getDecimalDigits(num: String): Int {
        return when {
            num.contains(".") -> {
                num.length - num.indexOf(".") - 1
            }
            else -> {
                0
            }
        }
    }
}