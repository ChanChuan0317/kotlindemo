package com.chanchuan.kotlindemo.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *@author : Chanchuan
 *Date       : 2020/12/29/029    下午 2:36
 *
 *
 */
class ProjectAdapter(
    var fragmentManager: FragmentManager,
    var mFragments: MutableList<Fragment>?,
    var mTitles: MutableList<String>?)
    : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return mFragments?.size ?: 0
    }

    override fun getItem(position: Int): Fragment {
        return mFragments!![position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if (mTitles != null && mTitles?.size != 0) mTitles!![position] else ""
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        if (mFragments != null && mFragments?.size != 0) {
            container.removeView(mFragments!![position].view)
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = mFragments!![position]
        if (!fragment.isAdded) {
            val beginTransaction = fragmentManager.beginTransaction()
            beginTransaction.add(fragment, fragment.javaClass.simpleName)
            beginTransaction.commitAllowingStateLoss()
            fragmentManager.executePendingTransactions()
        }
        if (fragment.requireView().parent == null) {
            container.addView(fragment.view)
        }
        return fragment
    }


}