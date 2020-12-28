package com.chanchuan.data.net

import com.chanchuan.data.ArticleBean
import com.chanchuan.data.BannerBean
import com.chanchuan.data.PublicBean
import com.chanchuan.data.QuestionBean
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

    /**
     * 福利妹子
     */
    @GET("v2/data/category/Girl/type/Girl/page/{page}/count/10")
    suspend fun getGirl(@Path("page") page: Int): GankBean

    /**
     * 微信公众号文章
     */
    @GET("wxarticle/chapters/json")
    suspend fun getWxPublic(): PublicBean

    /**
     * 首页Banner
     */
    @GET("banner/json")
    suspend fun getBanner(): BannerBean

    /**
     * 首页文章
     */
    //    https://www.wanandroid.com/article/list/0/json
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int): ArticleBean

    /**
     * 解答文章
     */
    @GET("wenda/list/{page}/json")
    suspend fun getQuestion(@Path("page") page: Int): QuestionBean


}