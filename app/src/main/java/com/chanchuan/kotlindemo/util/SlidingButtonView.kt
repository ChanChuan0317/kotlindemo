package com.chanchuan.kotlindemo.util

import android.content.Context
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import com.chanchuan.kotlindemo.R

/**
 *@author : Chanchuan
 *Date       : 2020/12/31/031    上午 10:15
 *
 *
 */
class SlidingButtonView(context: Context?) : HorizontalScrollView(context) {
    private lateinit var linearLayout: LinearLayout
    private var once: Boolean = false
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (!once) {
//            linearLayout= findViewById<LinearLayout>(R.layout.linear_layout)
        }
    }
}