package com.chanchuan.kotlindemo.util

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @author : Chanchuan
 * Date       : 2021/1/19/019    下午 4:50
 */
class CirclePgBar : View {

    private var mBackPaint: Paint? = null
    private var mFrontPaint: Paint? = null
    private var mTextPaint: Paint? = null;
    private var mStrokeWidth = 50F;
    private var mHalfStrokeWidth = mStrokeWidth / 2
    private var mRadius = 200F;
    private var mRect: RectF? = null
    private var mProgress = 0
    private var mTargetProgress = 100
    private var mMax = 100
    private var mWidth = 0
    private var mHeight = 0

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context,
        attrs,
        defStyleAttr) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes) {
        init()
    }

    fun init() {
        mBackPaint = Paint()
        mBackPaint!!.color = Color.WHITE
        mBackPaint!!.isAntiAlias = true
        mBackPaint!!.style = Paint.Style.STROKE
        mBackPaint!!.strokeWidth = mStrokeWidth

        mFrontPaint = Paint()
        mFrontPaint!!.color = Color.WHITE
        mFrontPaint!!.isAntiAlias = true
        mFrontPaint!!.style = Paint.Style.STROKE
        mFrontPaint!!.strokeWidth = mStrokeWidth

        mTextPaint = Paint()
        mTextPaint!!.color = Color.GREEN
        mTextPaint!!.isAntiAlias = true
        mTextPaint!!.textSize = 80F
        mTextPaint!!.textAlign = Paint.Align.CENTER
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = getRealSize(widthMeasureSpec)
        mHeight = getRealSize(heightMeasureSpec)
        setMeasuredDimension(mWidth, mHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        initRect()
        val angle = mProgress / (mMax * 360).toFloat()
        canvas!!.drawCircle((mWidth / 2).toFloat(), (mHeight / 2).toFloat(), mRadius, mBackPaint!!)
        canvas.drawArc(mRect!!, (-90).toFloat(), angle, false, mFrontPaint!!)
        canvas.drawText("${mProgress}${"%"}",
            mWidth / 2 + mHalfStrokeWidth,
            mHeight / 2 + mHalfStrokeWidth,
            mTextPaint!!)
        if (mProgress < mTargetProgress) {
            mProgress += 1
            invalidate()
        }

    }

    private fun initRect() {
        if (mRect == null) {
            var viewSize = (mRadius * 2).toInt()
            var left = (mWidth - viewSize) / 2
            var top = (mHeight - viewSize) / 2
            var right = left + viewSize
            var bottom = top + viewSize
            mRect = RectF(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
        }
    }

    private fun getRealSize(measureSpec: Int): Int {
        var result = 1;
        var mode = MeasureSpec.getMode(measureSpec)
        var size = MeasureSpec.getSize(measureSpec)
        if (mode == MeasureSpec.AT_MOST || mode == MeasureSpec.UNSPECIFIED) {
            result = (mRadius * 2 + mStrokeWidth).toInt()
        } else {
            result = size
        }
        return result
    }
}