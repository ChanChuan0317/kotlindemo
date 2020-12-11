package com.chanchuan.kotlindemo.mainpager

import android.util.Log
import com.chanchuan.data.ArticleBean

/**
 *@author : Chanchuan
 *Date       : 2020/12/11/011    上午 10:15
 *
 *
 */
class MainPagerPresenter(mainPagerView: IMainPagerView) {
    private var mainPagerModel: IMainPagerModel? = MainPagerModel()
    private var mainPagerView: IMainPagerView? = null

    fun getArticleList(page: Int) {
        mainPagerModel?.getArticleList(page, object : OnNetListener<ArticleBean> {
            override fun onSuccess(any: ArticleBean) {
                mainPagerView?.onSuccess(any)
            }

            override fun onFailed(e: Throwable) {
                Log.e("chanchuan", e.message)
                mainPagerView?.onFailed(e)
            }

        })
    }

}