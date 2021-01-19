package com.chanchuan.kotlindemo.fragment

import android.view.View
import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.util.KeyBoardUtils
import kotlinx.android.synthetic.main.fragment_demo.*
import kotlinx.android.synthetic.main.fragment_demo.view.*

/**
 *@author : Chanchuan
 *Date       : 2021/1/6/006    下午 5:19
 *
 *
 */
class DemoFragment : BaseFragment(), View.OnClickListener {
    override fun setLayoutId(): Int {
        return R.layout.fragment_demo;
    }

    override fun initView() {
        if (arguments != null) {

        }
        btn_show.setOnClickListener(this)
        btn_hide.setOnClickListener(this)
    }

    override fun initData() {

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_show -> {
                KeyBoardUtils.showKeyBoard(requireContext(), btn_show)
            }
            R.id.btn_hide -> {
                KeyBoardUtils.hideKeyBoard(requireContext(), btn_hide)
            }

        }
    }
}