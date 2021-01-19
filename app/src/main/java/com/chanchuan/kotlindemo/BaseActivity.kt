package com.chanchuan.kotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar

/**
 *@author : Chanchuan
 *Date       : 2020/12/9/009    上午 10:23
 *
 *
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        immersionBar {
            statusBarColor(R.color.transparent)
            navigationBarColor(R.color.transparent)
        }
//        StatusBarUtil.setStatusBarTranslucent(this, false)
//        if (StatusBarUtil.isXiaomi()) {
//            StatusBarUtil.setXiaomiStatusBar(window, false)
//        }
//        if (StatusBarUtil.isMeizu()) {
//            StatusBarUtil.setMeizuStatusBar(window, false)
//        }
        initView()
        initData()
    }

    abstract fun setLayoutId(): Int

    abstract fun initView()

    abstract fun initData()
}