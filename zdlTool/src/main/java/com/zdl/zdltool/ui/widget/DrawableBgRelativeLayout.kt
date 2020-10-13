package com.zdl.zdltool.ui.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.zdl.zdltool.R

/**
 * @author zdl
 * date 2020/1/8 18:18
 * email zdl328465042@163.com
 * description RelativeLayout渐变背景
 */
class DrawableBgRelativeLayout(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {

    private var gd: GradientDrawable

    private var shape = GradientDrawable.RECTANGLE
    var fillColor = Color.WHITE
        set(value) {
            gd.setColor(value)
            field = value
        }
    private var strokeColor = Int.MIN_VALUE
    private var strokeWidth = 1F

    //dashWidth > 0时，即表示为虚线
    private var dashWidth = -1F

    //虚线之间的间隔
    private var dashGap = -1F
    private var topLeftRadius = 0F
    private var topRightRadius = 0F
    private var bottomRightRadius = 0F
    private var bottomLeftRadius = 0F
    private var radius = 0F

    private var innerRadius = 0
    private var innerRadiusRatio = 0F
    private var thickness = 0
    private var thicknessRatio = 0F

    private var startColor = Color.WHITE
    private var centerColor = Int.MIN_VALUE
    private var endColor = Color.WHITE
    private var gradientType = GradientDrawable.LINEAR_GRADIENT
    private var orientation = GradientDrawable.Orientation.TOP_BOTTOM

    //渐变色半径.当 gradientType="RADIAL_GRADIENT" 时才使用。单独使用 android:type="radial"会报错。
    private var gradientRadius = 0F

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.DrawableBgRelativeLayout)
        strokeColor = ta.getColor(R.styleable.DrawableBgRelativeLayout_strokeColor, Int.MIN_VALUE)
        strokeWidth = ta.getDimension(R.styleable.DrawableBgRelativeLayout_strokeWidth, 1F)
        dashWidth = ta.getDimension(R.styleable.DrawableBgRelativeLayout_dashWidth, -1F)
        dashGap = ta.getDimension(R.styleable.DrawableBgRelativeLayout_dashGap, -1F)
        topLeftRadius = ta.getDimension(R.styleable.DrawableBgRelativeLayout_topLeftRadius, 0F)
        topRightRadius = ta.getDimension(R.styleable.DrawableBgRelativeLayout_topRightRadius, 0F)
        bottomRightRadius =
            ta.getDimension(R.styleable.DrawableBgRelativeLayout_bottomRightRadius, 0F)
        bottomLeftRadius =
            ta.getDimension(R.styleable.DrawableBgRelativeLayout_bottomLeftRadius, 0F)
        radius = ta.getDimension(R.styleable.DrawableBgRelativeLayout_radius, 0F)
        if (ta.getBoolean(R.styleable.DrawableBgRelativeLayout_isGradient, false)) {
            //gradient，渐变色
            startColor = ta.getColor(R.styleable.DrawableBgRelativeLayout_startColor, Color.WHITE)
            centerColor =
                ta.getColor(R.styleable.DrawableBgRelativeLayout_centerColor, Int.MIN_VALUE)
            endColor = ta.getColor(R.styleable.DrawableBgRelativeLayout_endColor, Color.WHITE)
            gradientType = when (ta.getInt(R.styleable.DrawableBgLinearLayout_gradientType, 0)) {
                1 -> GradientDrawable.RADIAL_GRADIENT
                2 -> GradientDrawable.SWEEP_GRADIENT
                else -> GradientDrawable.LINEAR_GRADIENT
            }
            orientation = when (ta.getInt(R.styleable.DrawableBgLinearLayout_orientation, 0)) {
                1 -> GradientDrawable.Orientation.TR_BL
                2 -> GradientDrawable.Orientation.RIGHT_LEFT
                3 -> GradientDrawable.Orientation.BR_TL
                4 -> GradientDrawable.Orientation.BOTTOM_TOP
                5 -> GradientDrawable.Orientation.BL_TR
                6 -> GradientDrawable.Orientation.LEFT_RIGHT
                7 -> GradientDrawable.Orientation.TL_BR
                else -> GradientDrawable.Orientation.TOP_BOTTOM
            }
            gradientRadius =
                ta.getDimension(R.styleable.DrawableBgRelativeLayout_gradientRadius, 0F)
            val colorArray = if (Int.MIN_VALUE == centerColor) {
                intArrayOf(startColor, endColor)
            } else {
                intArrayOf(startColor, centerColor, endColor)
            }
            gd = GradientDrawable(orientation, colorArray)
            gd.gradientType = gradientType
            if (gradientType == GradientDrawable.RADIAL_GRADIENT) {
                gd.gradientRadius = gradientRadius
            }
        } else {
            //shape，边框，圆角，背景
            gd = GradientDrawable()
            shape = when (ta.getInt(R.styleable.DrawableBgLinearLayout_shape, 0)) {
                1 -> GradientDrawable.OVAL
                2 -> GradientDrawable.LINE
                3 -> GradientDrawable.RING
                else -> GradientDrawable.RECTANGLE
            }
            fillColor = ta.getColor(R.styleable.DrawableBgRelativeLayout_fillColor, Color.WHITE)
            when (shape) {
                GradientDrawable.OVAL -> {
                }
                GradientDrawable.LINE -> {
                }
                GradientDrawable.RING -> {
                }
                else -> {
                }
            }
            //填充色
            gd.setColor(fillColor)
            gd.shape = shape
        }
        //边框颜色、粗细、虚实线
        if (Int.MIN_VALUE != strokeColor) {
            if (-1F != dashWidth) {
                gd.setStroke(strokeWidth.toInt(), strokeColor, dashWidth, dashGap)
            } else {
                gd.setStroke(strokeWidth.toInt(), strokeColor)
            }
        }
        //圆角
        if (0F != radius) {
            gd.cornerRadius = radius
        } else if (0F != topLeftRadius || 0F != topRightRadius || 0F != bottomRightRadius || 0F != bottomLeftRadius) {
            gd.cornerRadii = floatArrayOf(
                topLeftRadius,
                topLeftRadius,
                topRightRadius,
                topRightRadius,
                bottomRightRadius,
                bottomRightRadius,
                bottomLeftRadius,
                bottomLeftRadius
            )
        }
        background = gd
        ta.recycle()
    }
}