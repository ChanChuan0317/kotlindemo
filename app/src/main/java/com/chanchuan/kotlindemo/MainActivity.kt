package com.chanchuan.kotlindemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.chanchuan.data.net.NetManager
import com.gyf.immersionbar.ImmersionBar
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.chanchuan.kotlindemo.GankBean
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), GankAdapter.RecyclerItemClick, OnRefreshLoadMoreListener {
    var mGankAdapter: GankAdapter? = null
    var mData: MutableList<GankBean.Data> = mutableListOf()
    var page: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.layoutManager = GridLayoutManager(this, 2)
        mGankAdapter = GankAdapter(this, mData)
        recyclerview.adapter = mGankAdapter
        mGankAdapter!!.setRecyclerItemClick(this)
        refresh.setOnRefreshLoadMoreListener(this)
        initData(page)
    }

    private suspend fun getGirl(page: Int) = withContext(Dispatchers.IO) {
        NetManager.netManager.apiService.getGirl(1)
    }

    private fun initData(page: Int) {
//        CoroutineScope(Dispatchers.Main).launch {
//            getGirl(page).run {
//                if (page == 1) {
//                    mData.clear()
//                }
//                mData.addAll(this.data)
//                mGankAdapter!!.notifyDataSetChanged()
//            }
//        }

    }

    override fun onClick(position: Int) {
        var intent = Intent(this, ImageActivity::class.java)
        intent.putExtra("girl", mData[position].url)
        startActivity(intent)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        refreshLayout.finishRefresh()
        page = 1
        initData(page)
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        refreshLayout.finishLoadMore()
        page++
        initData(page)
    }

}