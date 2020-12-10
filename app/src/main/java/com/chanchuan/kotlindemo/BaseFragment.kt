package com.chanchuan.kotlindemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *@author : Chanchuan
 *Date       : 2020/12/9/009    上午 10:48
 *
 *
 */
abstract class BaseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(setLayoutId(), container, false)
        return inflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    abstract fun setLayoutId(): Int

    abstract fun initView()

    abstract fun initData()
}
