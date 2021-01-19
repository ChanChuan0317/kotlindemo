package com.chanchuan.kotlindemo.fragment

import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.adapter.VtbAdapter
import com.chanchuan.kotlindemo.util.KeyBoardUtils
import kotlinx.android.synthetic.main.fragment_demo.*
import kotlinx.android.synthetic.main.fragment_main_page.*
import q.rorbin.verticaltablayout.VerticalTabLayout
import q.rorbin.verticaltablayout.widget.TabView
import java.lang.reflect.TypeVariable


/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    上午 10:28
 *
 *
 */
class MainPagerFragment : BaseFragment(), View.OnClickListener {
    override fun setLayoutId(): Int {
        return R.layout.fragment_demo;
    }


    override fun initView() {
        btn_show.setOnClickListener(this)
        btn_hide.setOnClickListener(this)

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

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_show -> {
                KeyBoardUtils.showKeyBoard(requireActivity(), btn_show)
            }
            R.id.btn_hide -> {
                KeyBoardUtils.hideKeyBoard(requireActivity(), btn_hide)
            }
        }
    }


}