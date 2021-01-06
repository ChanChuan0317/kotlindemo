package com.chanchuan.data

/**
 *@author : Chanchuan
 *Date       : 2020/12/29/029    上午 11:03
 *
 *
 */
data class ProjectBean(
    val `data`: List<Data>,
    val errorCode: Int,
    val errorMsg: String
) {


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
}
