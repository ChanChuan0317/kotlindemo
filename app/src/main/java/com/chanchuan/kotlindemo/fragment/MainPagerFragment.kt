package com.chanchuan.kotlindemo.fragment

import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.activity_main.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    上午 10:28
 *
 *
 */
class MainPagerFragment : BaseFragment(), OnRefreshLoadMoreListener {
    var page: Int = 1;
    override fun setLayoutId(): Int {
        return R.layout.fragment_main_page;
    }

    override fun initView() {
        refresh.setOnRefreshLoadMoreListener(this)
    }

    override fun initData() {
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {

    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        TODO("Not yet implemented")
    }
}