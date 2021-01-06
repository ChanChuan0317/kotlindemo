package com.chanchuan.kotlindemo.fragment

import androidx.fragment.app.Fragment
import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.adapter.VtbAdapter
import kotlinx.android.synthetic.main.fragment_main_page.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    上午 10:28
 *
 *
 */
class MainPagerFragment : BaseFragment() {
    var mTitle = mutableListOf<String>()
    var mData = mutableListOf<Fragment>()
    override fun setLayoutId(): Int {
        return R.layout.fragment_main_page;
    }

    override fun initView() {
        mTitle.add("课程")
        mTitle.add("品牌")
        val demoFragment = DemoFragment()
        val demoFragment2 = DemoFragment()
        mData.add(demoFragment)
        mData.add(demoFragment2)
        val vtbAdapter = VtbAdapter(fragmentManager, mTitle, mData)
        vp_viewPager.adapter = vtbAdapter
        vtl_title.setupWithViewPager(vp_viewPager)
    }

//    private suspend fun getPublic(page: Int) = withContext(Dispatchers.IO) {
//        NetManager.netManager.apiService.getArticleList(page)
//    }

    override fun initData() {
//        CoroutineScope(Dispatchers.Main).launch {
//            getPublic(page).run {
//                if (page == 1) {
//                    mData?.clear()
//                }
//                mData?.addAll(this.data.datas)
//                mMainPagerAdapter!!.notifyDataSetChanged()
//            }
//        }
    }

}