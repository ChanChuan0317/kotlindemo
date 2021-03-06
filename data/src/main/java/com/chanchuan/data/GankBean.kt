package com.chanchuan.kotlindemo

/**
 *@author : Chanchuan
 *Date       : 2020/12/8/008    上午 10:40
 *
 *
 */
data class GankBean(
        val `data`: List<Data>,
        val page: Int,
        val page_count: Int,
        val status: Int,
        val total_counts: Int
) {
    data class Data(
            val _id: String,
            val author: String,
            val category: String,
            val createdAt: String,
            val desc: String,
            val images: List<String>,
            val likeCounts: Int,
            val publishedAt: String,
            val stars: Int,
            val title: String,
            val type: String,
            val url: String,
            val views: Int
    )
}

