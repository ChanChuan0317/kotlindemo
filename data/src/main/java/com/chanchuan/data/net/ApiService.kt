package com.chanchuan.data.net

import com.chanchuan.data.ArticleBean
import com.chanchuan.data.BannerBean
import com.chanchuan.data.PublicBean
import com.chanchuan.kotlindemo.GankBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *@author : Chanchuan
 *Date       : 2020/12/8/008    上午 10:30
 *
 *
 */
interface ApiService {
    object urls {
        var gankUrl = "https://gank.io/api/"
        var baseUrl = "https://www.wanandroid.com/"
    }


    @GET("v2/data/category/Girl/type/Girl/page/{page}/count/10")
    fun getGirl(@Path("page") page: Int): Observable<GankBean>

    @GET("wxarticle/chapters/json")
    fun getWxPublic(): Observable<PublicBean>

    @GET("banner/json")
    fun getBanner(): Observable<BannerBean>

    @GET("article/list/{page}/json")
    fun getArticleList(@Path("page") page: Int): Observable<ArticleBean>


}