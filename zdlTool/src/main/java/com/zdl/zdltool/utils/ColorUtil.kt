package com.zdl.zdltool.utils

import android.graphics.Color
import java.util.*

/**
 * @author zdl
 * date 2020/1/8 16:50
 * email zdl328465042@163.com
 * description 颜色相关的工具类
 */
object ColorUtil {

    /**
     * 百分比透明度转十六进制
     * @param alpha 百分比，如60%
     */
    fun colorInt2hex(alpha: Float): String {
        var s = Integer.toHexString((alpha * 256).toInt()).toUpperCase()
        if (s.length == 1) {
            s = "0$s"
        }
        return s
    }

    /**
     * 得到指定透明度的色值
     * @param alpha 透明度:0%~99%
     * @param colorStr 十六进制色值
     */
    fun getAlphaColor(colorStr: String, alpha: Float): String {
        return "#${colorInt2hex(alpha)}${colorStr.replace("#", "")}"
    }

    /**
     * 得到指定透明度的int色值
     * @param alpha 透明度:0%~99%
     * @param colorStr 十六进制色值
     */
    fun getIntAlphaColor(colorStr: String, alpha: Float): Int {
        return getIntColor(getAlphaColor(colorStr, alpha))
    }

    /**
     * 得到颜色转换后的int值
     * @param colorStr 颜色
     */
    fun getIntColor(colorStr: String): Int {
        return Color.parseColor(colorStr)
    }

    /**
     * 获取随机颜色值
     * @return 颜色值
     */
    fun getRandomColor(): String {
        val random = Random()
        val r = NumberUtil.int2hex(random.nextInt(256))
        val g = NumberUtil.int2hex(random.nextInt(256))
        val b = NumberUtil.int2hex(random.nextInt(256))
        return "#$r$g$b"
    }
}