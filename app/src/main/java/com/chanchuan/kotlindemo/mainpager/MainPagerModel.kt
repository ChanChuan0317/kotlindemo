package com.chanchuan.kotlindemo.mainpager

import com.chanchuan.data.ArticleBean
import com.chanchuan.data.net.BaseObserver
import com.chanchuan.data.net.NetManager
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *@author : Chanchuan
 *Date       : 2020/12/11/011    上午 10:04
 *
 *
 */
class MainPagerModel : IMainPagerModel {
    override fun getArticleList(page: Int, onNetListener: OnNetListener<ArticleBean>) {
//        NetManager.createApi().getArticleList(page)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : BaseObserver<ArticleBean>() {
//                override fun onSuccess(t: Any) {
//                    onNetListener.onSuccess(t as ArticleBean)
//                }
//
//                override fun onFailed(e: Throwable) {
//                    onNetListener.onFailed(e)
//                }
//
//            })
    }
}