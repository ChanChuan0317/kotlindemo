package com.chanchuan.kotlindemo.mainpager

import com.chanchuan.data.ArticleBean

/**
 *@author : Chanchuan
 *Date       : 2020/12/11/011    上午 9:52
 *
 *
 */
interface IMainPagerModel {
    fun getArticleList(page: Int, onNetListener: OnNetListener<ArticleBean>)
}