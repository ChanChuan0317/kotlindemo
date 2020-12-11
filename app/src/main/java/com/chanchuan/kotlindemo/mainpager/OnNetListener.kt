package com.chanchuan.kotlindemo.mainpager

/**
 *@author : Chanchuan
 *Date       : 2020/12/11/011    上午 10:05
 *
 *
 */
interface OnNetListener<Any> {
    fun onSuccess(any: Any)
    fun onFailed(e: Throwable)
}