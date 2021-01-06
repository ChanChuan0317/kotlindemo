package com.chanchuan.data.net

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *@author : Chanchuan
 *Date       : 2020/12/9/009    上午 10:01
 *
 *
 */
class NetManager private constructor() {
    var apiService: ApiService

    companion object {
        val netManager: NetManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { NetManager() }
    }

    init {
        apiService = Retrofit.Builder()
            .baseUrl(ApiService.urls.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java);
    }

}