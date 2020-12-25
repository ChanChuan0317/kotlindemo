package com.chanchuan.kotlindemo

import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/18/018    下午 3:40
 *
 *
 */
class WebViewActivity : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.activity_webview;
    }

    override fun initView() {
        if (intent != null) {
            val stringExtra = intent.getStringExtra("questionLink")
            webView.loadUrl(stringExtra)
            webView.webChromeClient = WebChromeClient()
            webView.webViewClient = WebViewClient()
        }
        iv_back.setOnClickListener { finish() }
    }

    override fun initData() {

    }
}