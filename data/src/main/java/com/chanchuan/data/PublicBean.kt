package com.chanchuan.data

/**
 *@author : Chanchuan
 *Date       : 2020/12/9/009    上午 9:55
 *
 *
 */
data class PublicBean(
    val `data`: List<Data>,
    val errorCode: Int,
    val errorMsg: String
)

data class Data(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)