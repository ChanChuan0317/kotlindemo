package com.chanchuan.kotlindemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.chanchuan.data.net.ApiService
import com.gyf.immersionbar.ImmersionBar
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), GankAdapter.RecyclerItemClick, OnRefreshLoadMoreListener {
    var mGankAdapter: GankAdapter? = null
    var mData = mutableListOf<Data>()
    var page: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ImmersionBar.with(this).transparentStatusBar();
        recyclerview.layoutManager = GridLayoutManager(this, 2)
        mGankAdapter = GankAdapter(this, mData)
        recyclerview.adapter = mGankAdapter
        mGankAdapter!!.setRecyclerItemClick(this)
        refresh.setOnRefreshLoadMoreListener(this)
        initData(page)
    }

    private fun initData(page: Int) {
        val build = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.urls.gankUrl)
                .build()
        val girl = build.create(ApiService::class.java).getGirl(page)
        girl.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GankBean> {
                    override fun onNext(t: GankBean) {
                        val data = t.data
                        if (page == 1) {
                            mData.clear()
                        }
                        mData.addAll(data)
                        mGankAdapter!!.notifyDataSetChanged()
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                    }

                })
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