package com.chanchuan.kotlindemo.question

import com.chanchuan.data.QuestionBean
import com.chanchuan.kotlindemo.mainpager.OnNetListener

/**
 *@author : Chanchuan
 *Date       : 2020/12/15/015    下午 2:15
 *
 *
 */
interface IQuestionModel {
    fun getQuestion(pPage: Int, pOnNetListener: OnNetListener<QuestionBean>)
}