package com.zdl.zdltool.utils

import android.os.Build
import androidx.annotation.CheckResult

/**
 * @author zdl
 * email zdl328465042@163.com
 * description
 */
object AndroidVersion {

    /**
     * 判断当前手机系统版本API是否是16以上，4.1
     * @return 16及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasJellyBean(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN

    /**
     * 判断当前手机系统版本API是否是17以上，4.2
     * @return 17及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasJellyBeanMR1(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1

    /**
     * 判断当前手机系统版本API是否是18以上，4.3
     * @return 18及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasJellyBeanMR2(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2

    /**
     * 判断当前手机系统版本API是否是19以上，4.4
     * @return 19及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasKitkat(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT

    /**
     * 判断当前手机系统版本API是否是21以上，5.0
     * @return 21及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasLollipop(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP

    /**
     * 判断当前手机系统版本API是否是22以上，5.1
     * @return 22及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasLollipopMR1(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1

    /**
     * 判断当前手机系统版本API是否是23以上，6.0
     * @return 23及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasMarshmallow(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

    /**
     * 判断当前手机系统版本API是否是24以上，7.0
     * @return 24及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasNougat(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N

    /**
     * 判断当前手机系统版本API是否是26以上，8.0
     * @return 26及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasOreo(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O

    /**
     * 判断当前手机系统版本API是否是28以上，9.0
     * @return 28及以上返回true，否则返回false。
     */
    @CheckResult
    fun hasPie(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P

    /**
     * 判断当前手机系统版本API是否是29以上，10.0
     * @return 29及以上返回true，否则返回false。
     */
//    @CheckResult
//    fun hasQ(): Boolean  Build.VERSION.SDK_INT >= Build.VERSION_CODES
}