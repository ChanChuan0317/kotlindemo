package com.chanchuan.kotlindemo.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chanchuan.data.ProChildBean
import com.chanchuan.data.net.NetManager
import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.WebViewActivity
import com.chanchuan.kotlindemo.adapter.ProChildAdapter
import com.chanchuan.kotlindemo.interfaces.RecyclerItemClick
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *@author : Chanchuan
 *Date       : 2020/12/29/029    下午 3:45
 *
 *
 */
class ProChildFragment : BaseFragment(), OnRefreshLoadMoreListener, RecyclerItemClick {
    private var page: Int = 1
    private var cid: Int = 0
    private var mData = mutableListOf<ProChildBean.Data.DataX>()
    private var proChildAdapter: ProChildAdapter? = null

    companion object

    fun newInstance(cid: Int): ProChildFragment {
        val proChildFragment = ProChildFragment()
        val bundle = Bundle()
        bundle.putSerializable("cid", cid)
        proChildFragment.let { this.arguments = bundle }
        return proChildFragment
    }

    override fun setLayoutId(): Int {
        return R.layout.fragment_child
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (arguments != null) {
            cid = arguments?.getSerializable("cid") as Int
        }
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun initView() {

        Log.v("--------------", "$cid")
        recyclerView.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        refresh.setOnRefreshLoadMoreListener(this)
        proChildAdapter = ProChildAdapter(mData, requireActivity())
        proChildAdapter!!.setRecyclerItemClick(this)
        recyclerView.adapter = proChildAdapter

    }

    private suspend fun getProChildData(page: Int, cid: Int) = withContext(Dispatchers.IO) {
        NetManager.netManager.apiService.getChildProject(page, cid)
    }

    override fun initData() {
        CoroutineScope(Dispatchers.Main).launch {
            if (page == 1) {
                mData.clear()
            }
            mData.addAll(getProChildData(page, cid).data.datas)
            proChildAdapter!!.notifyDataSetChanged()
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        refreshLayout.finishRefresh()
        page = 1
        initData()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        refreshLayout.finishLoadMore()
        page++
        initData()
    }

    override fun itemClick(position: Int) {
        mData[position].let {
            val intent = Intent(activity, WebViewActivity::class.java)
            intent.putExtra("link", it.link)
            requireActivity().startActivity(intent)
        }
    }
}