package com.chanchuan.kotlindemo.fragment

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.chanchuan.data.QuestionBean
import com.chanchuan.data.QuestionDataX
import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.WebViewActivity
import com.chanchuan.kotlindemo.adapter.QuestionAdapter
import com.chanchuan.kotlindemo.mainpager.QuestionPresenter
import com.chanchuan.kotlindemo.question.IQuestionView
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.fragment_question.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    上午 10:30
 *
 *
 */
class QuestionFragment : BaseFragment(), OnRefreshLoadMoreListener, IQuestionView, QuestionAdapter.OnItemClick {
    private var page: Int = 0;
    private var mData = mutableListOf<QuestionDataX>()
    private var questionAdapter: QuestionAdapter? = null
    private var questionPresenter: QuestionPresenter? = null
    override fun setLayoutId(): Int {
        return R.layout.fragment_question;
    }

    override fun initView() {
        refresh.setOnRefreshLoadMoreListener(this)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        questionAdapter = QuestionAdapter(requireActivity(), mData)
        recyclerView.adapter = questionAdapter
        questionAdapter!!.setOnItemClick(this)
        questionPresenter = QuestionPresenter(this)
    }

    override fun initData() {
        questionPresenter!!.getQuestion(page)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        refreshLayout.finishRefresh()
        page = 0
        questionPresenter!!.getQuestion(page)
    }


    override fun onLoadMore(refreshLayout: RefreshLayout) {
        refreshLayout.finishLoadMore()
        page++
        questionPresenter!!.getQuestion(page)
    }

    override fun onSuccess(pQuestionBean: QuestionBean) {
        val datas = pQuestionBean.data.datas
        if (page == 0) {
            mData.clear()
        }
        mData.addAll(datas)
        questionAdapter!!.notifyDataSetChanged()
    }

    override fun onFailed(pThrowable: Throwable) {
        Log.e("error" + javaClass.name, pThrowable.message)
    }

    override fun itemClick(position: Int) {
        var intent = Intent(activity, WebViewActivity::class.java)
        val link = mData[position].link
        intent.putExtra("questionLink", link)
        activity?.startActivity(intent)
    }
}