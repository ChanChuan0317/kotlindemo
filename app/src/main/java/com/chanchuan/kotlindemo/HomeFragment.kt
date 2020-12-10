package com.chanchuan.kotlindemo

import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/9/009    上午 11:00
 *
 *
 */
class HomeFragment : BaseFragment() {
    var navController: NavController? = null
    override fun setLayoutId(): Int {
        return R.layout.fragment_home;
    }

    override fun initView() {
        navController =
            Navigation.findNavController((requireView().findViewById(R.id.navigation_main)))
        navigation_bottom_view.itemIconTintList = null
        navigation_bottom_view.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                if (item.itemId == R.id.item_home) navController!!.navigate(R.id.mainPagerFragment)
                if (item.itemId == R.id.item_answer) navController!!.navigate(R.id.questionFragment)
                if (item.itemId == R.id.item_knowledge) navController!!.navigate(R.id.knowledgeFragment)
                if (item.itemId == R.id.item_user) navController!!.navigate(R.id.mineFragment)
                item.isChecked = true
                return false
            }

        })
    }



    override fun initData() {
    }
}