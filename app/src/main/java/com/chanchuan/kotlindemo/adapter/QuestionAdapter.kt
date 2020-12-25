package com.chanchuan.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chanchuan.data.QuestionDataX
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.util.DateUtil
import kotlinx.android.synthetic.main.item_main_pager.view.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    下午 3:40
 *
 *
 */
class QuestionAdapter(var context: Context, var data: MutableList<QuestionDataX>?) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {
    private var mContext: Context? = context
    private var mData: MutableList<QuestionDataX>? = data;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main_pager, parent, false))
    }

    override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, position: Int) {
        holder.itemView.run {
            mData!![position].let {
                this.tv_title.text = it.author
                this.tv_time.text = DateUtil.transformTimestamp(it.publishTime)
                this.tv_content.text = it.title
                //                this.tv_desc.text = it.desc
                this.tv_classification.text = "${it.superChapterName}·${it.chapterName}"
            }
        }
        holder.itemView.setOnClickListener {
            if (onItemClick != null) {
                onItemClick!!.itemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    private var onItemClick: OnItemClick? = null
    fun setOnItemClick(mOnItemClick: OnItemClick) {
        this.onItemClick = mOnItemClick
    }

    interface OnItemClick {
        fun itemClick(position: Int)
    }

}