package com.chanchuan.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chanchuan.data.DataX
import com.chanchuan.kotlindemo.R
import kotlinx.android.synthetic.main.item_main_pager.view.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    下午 3:40
 *
 *
 */
class MainPagerAdapter(var context: Context, var data: MutableList<DataX>?) :
    RecyclerView.Adapter<MainPagerAdapter.ViewHolder>() {
    private var mContext: Context? = context
    private var mData: MutableList<DataX>? = data;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPagerAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext)
            .inflate(R.layout.item_main_pager, parent, false))
    }

    override fun onBindViewHolder(holder: MainPagerAdapter.ViewHolder, position: Int) {
        holder.itemView.run {
            mData!![position].let {
                this.tv_title.text = it.author
                this.tv_time.text = it.publishTime.toString()
                this.tv_content.text = it.title
                this.tv_classification.text = "${it.chapterName}·${it.superChapterName}"
            }
        }
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}