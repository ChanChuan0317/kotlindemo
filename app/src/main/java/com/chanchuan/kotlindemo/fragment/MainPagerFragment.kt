package com.chanchuan.kotlindemo.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.chanchuan.data.DataX
import com.chanchuan.data.net.NetManager
import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.adapter.MainPagerAdapter
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.activity_main.refresh
import kotlinx.android.synthetic.main.fragment_main_page.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    上午 10:28
 *
 *
 */
class MainPagerFragment : BaseFragment(), OnRefreshLoadMoreListener {
    var mMainPagerAdapter: MainPagerAdapter? = null
    var mData: MutableList<DataX>? = mutableListOf()
    var page: Int = 0
    override fun setLayoutId(): Int {
        return R.layout.fragment_main_page;
    }

    override fun initView() {
        refresh.setOnRefreshLoadMoreListener(this)
        recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mMainPagerAdapter = MainPagerAdapter(requireActivity(), mData)
    }

    private suspend fun getPublic(page: Int) = withContext(Dispatchers.IO) {
        NetManager.netManager.apiService.getArticleList(page)
    }

    override fun initData() {
        CoroutineScope(Dispatchers.Main).launch {
            getPublic(page).run {
                if (page == 1) {
                    mData?.clear()
                }
                mData?.addAll(this.data.datas)
                mMainPagerAdapter!!.notifyDataSetChanged()
            }
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        refreshLayout.finishRefresh()
        page = 0
        initData()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        refreshLayout.finishLoadMore()
        page++
        initData()
    }

}