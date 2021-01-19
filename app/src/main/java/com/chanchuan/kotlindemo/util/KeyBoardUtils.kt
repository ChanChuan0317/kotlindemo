package com.chanchuan.kotlindemo.util

import android.content.Context
import android.telephony.ims.ImsMmTelManager
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 *@author : Chanchuan
 *Date       : 2021/1/18/018    下午 3:31
 *
 *
 */
class KeyBoardUtils {
    companion object {
        fun hideKeyBoard(context: Context, view: View) {
            var imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun showKeyBoard(context: Context, view: View) {
            var imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

}