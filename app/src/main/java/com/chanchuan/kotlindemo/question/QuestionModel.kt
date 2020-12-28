package com.chanchuan.kotlindemo.question

import com.chanchuan.data.QuestionBean
import com.chanchuan.data.net.BaseObserver
import com.chanchuan.data.net.NetManager
import com.chanchuan.kotlindemo.mainpager.OnNetListener
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/15/015    下午 2:18
 *
 *
 */
class QuestionModel : IQuestionModel {
    override fun getQuestion(pPage: Int, pOnNetListener: OnNetListener<QuestionBean>) {
//        val question = NetManager.createApi().getQuestion(pPage)
//        question.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : BaseObserver<QuestionBean>() {
//                override fun onSuccess(t: Any) {
//                    pOnNetListener.onSuccess(t as QuestionBean)
//                }
//
//                override fun onFailed(e: Throwable) {
//                    pOnNetListener.onFailed(e)
//                }
//
//            })
    }

}