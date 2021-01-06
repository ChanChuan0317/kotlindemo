package com.chanchuan.kotlindemo.fragment

import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R

/**
 *@author : Chanchuan
 *Date       : 2021/1/6/006    下午 5:19
 *
 *
 */
class DemoFragment : BaseFragment() {
    override fun setLayoutId(): Int {
        return R.layout.fragment_demo;
    }

    override fun initView() {
        if (arguments != null) {

        }
    }

    override fun initData() {

    }
}