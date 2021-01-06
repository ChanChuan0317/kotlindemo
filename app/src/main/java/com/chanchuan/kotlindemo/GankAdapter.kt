package com.chanchuan.kotlindemo

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chanchuan.kotlindemo.interfaces.RecyclerItemClick
import kotlinx.android.synthetic.main.item_gank.view.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/7/007    下午 5:55
 *
 *
 */
class GankAdapter(var context: Context, val gank: MutableList<GankBean.Data>) : RecyclerView.Adapter<GankAdapter.ViewHolder>() {

    private val mContext: Context? = context
    private var mGank: MutableList<GankBean.Data>? = gank

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_gank, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.run {
            mGank!![position].let {
                this.sdv_image.setImageURI(Uri.parse(it.url))
                this.setOnClickListener {
                    mRecyclerItemClick?.itemClick(position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mGank!!.size
    }


    private var mRecyclerItemClick: RecyclerItemClick? = null

    fun setRecyclerItemClick(onClick: RecyclerItemClick) {
        this.mRecyclerItemClick = onClick
    }
}