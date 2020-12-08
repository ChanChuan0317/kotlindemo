package com.chanchuan.kotlindemo

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
    }

    @GET("v2/data/category/Girl/type/Girl/page/{page}/count/10")
    fun getGirl(@Path("page") page: Int): Observable<GankBean>
}