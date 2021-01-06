package com.chanchuan.kotlindemo.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chanchuan.data.ProChildBean
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.interfaces.RecyclerItemClick
import com.chanchuan.kotlindemo.util.DateUtil
import kotlinx.android.synthetic.main.item_child.view.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/29/029    下午 5:21
 *
 *
 */
class ProChildAdapter(var mData: MutableList<ProChildBean.Data.DataX>, var mContext: Context) :
    RecyclerView.Adapter<ProChildAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProChildAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_child, parent, false))
    }

    override fun onBindViewHolder(holder: ProChildAdapter.ViewHolder, position: Int) {
        holder.itemView.run {
            mData[position].let {
                this.tv_title.text = it.title
                this.tv_content.text = it.desc
                this.sdv_image.setImageURI(Uri.parse(it.envelopePic))
                this.tv_author.text = it.author
                this.tv_time.text = DateUtil.transformTimestamp(it.publishTime)
                this.setOnClickListener {
                    if (mRecyclerItemClick != null) {
                        mRecyclerItemClick!!.itemClick(position)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    private var mRecyclerItemClick: RecyclerItemClick? = null

    fun setRecyclerItemClick(onClick: RecyclerItemClick) {
        this.mRecyclerItemClick = onClick
    }
}