package com.chanchuan.kotlindemo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

/**
 *@author : Chanchuan
 *Date       : 2020/12/9/009    上午 10:23
 *
 *
 */
abstract class BaseActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initView()
        initData()
    }

    abstract fun setLayoutId(): Int

    abstract fun initView()

    abstract fun initData()
}