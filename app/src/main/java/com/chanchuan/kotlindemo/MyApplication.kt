package com.chanchuan.kotlindemo

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco

/**
 *@author : Chanchuan
 *Date       : 2020/12/7/007    下午 5:31
 *
 *
 */
class MyApplication : Application() {
    //    val mContext
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}