package com.chanchuan.kotlindemo.fragment

import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsAnimation
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import kotlinx.android.synthetic.main.fragment_mine.*
import java.util.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    上午 10:36
 *
 *
 */
class MineFragment : BaseFragment(), View.OnClickListener {
    override fun setLayoutId(): Int {
        return R.layout.fragment_mine;
    }

    override fun initView() {
        iv_user_img.setImageURI(Uri.parse("https://gank.io/images/bdd1fb6886744bc9838a1b85495a99f7"));
        ll_login.setOnClickListener(this)
        val llEtDemo = R.id.ll_et_demo
        val rootView = ll_et_demo.rootView
    }

    override fun initData() {
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ll_login -> Navigation.findNavController(requireActivity(), R.id.navigation_main)

        }
    }
}