package com.zdl.core.utils

import android.text.Html
import android.widget.TextView
import androidx.annotation.CheckResult
import com.zdl.zdltool.utils.AndroidVersion

/**
 * @author zdl
 * date 2019/6/18 17:45
 * email zdl328465042@163.com
 * description 字符串相关工具类
 */
object StringUtil {

    /**
     * 判断字符串是否为空
     * @param str 目标字符串
     * @return true:空,false:非空
     */
    @CheckResult
    fun isEmpty(str: String?): Boolean {
        return null == str || str.trim().isEmpty() || "null" == str
    }

    /**
     * 在TextView中设置html
     * @param tv 目标TextView
     * @param html 目标html
     */
    fun setHtmlTxt(tv: TextView, html: String) {
        tv.text = if (AndroidVersion.hasNougat()) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html)
        }
    }
}