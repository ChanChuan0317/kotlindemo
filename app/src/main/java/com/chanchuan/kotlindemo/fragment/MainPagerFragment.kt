package com.chanchuan.kotlindemo.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.chanchuan.data.ArticleBean
import com.chanchuan.data.DataX
import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.adapter.MainPagerAdapter
import com.chanchuan.kotlindemo.mainpager.IMainPagerView
import com.chanchuan.kotlindemo.mainpager.MainPagerPresenter
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.activity_main.refresh
import kotlinx.android.synthetic.main.fragment_main_page.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    上午 10:28
 *
 *
 */
class MainPagerFragment : BaseFragment(), OnRefreshLoadMoreListener, IMainPagerView {
    var mMainPagerPresenter: MainPagerPresenter? = null
    var mMainPagerAdapter: MainPagerAdapter? = null
    var mData: MutableList<DataX>? = mutableListOf()
    var page: Int = 0
    override fun setLayoutId(): Int {
        return R.layout.fragment_main_page;
    }

    override fun initView() {
        refresh.setOnRefreshLoadMoreListener(this)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mMainPagerAdapter = MainPagerAdapter(requireActivity(), mData)
        mMainPagerPresenter = MainPagerPresenter(this)
        CoroutineScope(Dispatchers.Main).launch {

        }
    }

    override fun initData() {
        mMainPagerPresenter!!.getArticleList(page)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        refreshLayout.finishRefresh()
        page = 0
        mMainPagerPresenter!!.getArticleList(page)
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        refreshLayout.finishLoadMore()
        page++
        mMainPagerPresenter!!.getArticleList(page)
    }

    override fun onSuccess(any: ArticleBean) {
        if (page == 0) {
            mData!!.clear()
        }
        mData?.addAll(any.data.datas)
        mMainPagerAdapter!!.notifyDataSetChanged()
    }

    override fun onFailed(e: Throwable) {

    }
}