package com.chanchuan.kotlindemo.mainpager

import com.chanchuan.data.QuestionBean
import com.chanchuan.kotlindemo.question.IQuestionView
import com.chanchuan.kotlindemo.question.QuestionModel

/**
 *@author : Chanchuan
 *Date       : 2020/12/15/015    下午 2:31
 *
 *
 */
class QuestionPresenter(pQuestionView: IQuestionView) {
    var mQuestionView: IQuestionView? = pQuestionView
    var mQuestionModel: QuestionModel = QuestionModel()

    fun getQuestion(pPage: Int) {
        mQuestionModel!!.getQuestion(pPage, object : OnNetListener<QuestionBean> {
            override fun onSuccess(any: QuestionBean) {
                mQuestionView!!.onSuccess(any)
            }

            override fun onFailed(e: Throwable) {
                mQuestionView!!.onFailed(e)
            }

        })
    }
}