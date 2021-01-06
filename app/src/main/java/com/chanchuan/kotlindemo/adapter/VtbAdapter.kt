package com.chanchuan.kotlindemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *@author : Chanchuan
 *Date       : 2021/1/6/006    下午 5:16
 *
 *
 */
class VtbAdapter(var fm: FragmentManager?, var mTitle: MutableList<String>?=null, var mData: MutableList<Fragment>?=null) :
    FragmentPagerAdapter(fm!!) {

    override fun getCount(): Int {
        return mTitle!!.size
    }

    override fun getItem(position: Int): Fragment {
        return mData!![position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitle!![position]
    }
}