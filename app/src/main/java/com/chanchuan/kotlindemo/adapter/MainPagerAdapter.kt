package com.chanchuan.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chanchuan.kotlindemo.R
import com.google.android.material.transition.Hold

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    下午 3:40
 *
 *
 */
class MainPagerAdapter(var context: Context, var data: MutableList<String>) :
    RecyclerView.Adapter<MainPagerAdapter.ViewHolder>() {
    private var mContext: Context? = context
    private var mData: MutableList<String>? = data;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPagerAdapter.ViewHolder {
        return  ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main_pager,parent,false))
    }

    override fun onBindViewHolder(holder: MainPagerAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}