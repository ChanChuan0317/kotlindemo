package com.chanchuan.kotlindemo.question

import com.chanchuan.data.QuestionBean

/**
 *@author : Chanchuan
 *Date       : 2020/12/15/015    下午 2:14
 *
 *
 */
interface IQuestionView {
    fun onSuccess(pQuestionBean: QuestionBean)
    fun onFailed(pThrowable: Throwable)
}