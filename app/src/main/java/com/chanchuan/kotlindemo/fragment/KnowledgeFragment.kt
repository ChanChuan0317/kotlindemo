package com.chanchuan.kotlindemo.fragment

import androidx.fragment.app.Fragment
import com.chanchuan.data.net.NetManager
import com.chanchuan.kotlindemo.BaseFragment
import com.chanchuan.kotlindemo.R
import com.chanchuan.kotlindemo.adapter.ProjectAdapter
import kotlinx.android.synthetic.main.fragment_knowledge.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *@author : Chanchuan
 *Date       : 2020/12/10/010    上午 10:33
 *
 *
 */
class KnowledgeFragment : BaseFragment() {
    override fun setLayoutId(): Int {
        return R.layout.fragment_knowledge;
    }

    override fun initView() {

    }

    private suspend fun getProjectTab() = withContext(Dispatchers.IO) {
        NetManager.netManager.apiService.getProject()
    }


    override fun initData() {
        CoroutineScope(Dispatchers.Main).launch {
            var mTitles = mutableListOf<String>()
            var mFragments = mutableListOf<Fragment>()
            for (datum in getProjectTab().data) {
                mTitles.add(datum.name)
                val newInstance = ProChildFragment().newInstance(datum.id)
                mFragments.add(newInstance)
            }
            viewPager.adapter = ProjectAdapter(requireFragmentManager(), mFragments, mTitles)
            tab_layout.setupWithViewPager(viewPager, true)
        }
    }
}
