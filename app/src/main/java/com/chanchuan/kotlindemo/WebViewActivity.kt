package com.chanchuan.kotlindemo

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Bitmap
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import com.chanchuan.kotlindemo.R.color.transparent
import kotlinx.android.synthetic.main.activity_webview.*

/**
 *@author : Chanchuan
 *Date       : 2020/12/18/018    下午 3:40
 */
class WebViewActivity : BaseActivity() {
    private var progressDialog: Dialog? = null
    override fun setLayoutId(): Int {
        return R.layout.activity_webview
    }

    override fun initView() {
        initDialog()
        if (intent != null) {
            val stringExtra = intent.getStringExtra("link")
            if (stringExtra != null) {
                initWebSetting()
                webView.loadUrl(stringExtra)
            }
            webView.webChromeClient = WebChromeClient()
            webView.webViewClient = WebViewClient()
        }
        iv_back.setOnClickListener { finish() }
    }

    private fun initDialog() {
        progressDialog = Dialog(this, R.style.progress_dialog)
        progressDialog!!.setContentView(R.layout.progress_custom)
        progressDialog!!.setCancelable(true)
        progressDialog!!.window!!.setBackgroundDrawableResource(transparent)
        var textView = progressDialog!!.findViewById<TextView>(R.id.tv_loadingmsg)
        textView.text = "加载中"
    }

    private fun initWebSetting() {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSettings.textSize = WebSettings.TextSize.NORMAL
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressDialog!!.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressDialog!!.dismiss()
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view!!.loadUrl(url!!)
                return true
            }
        }
    }

    override fun initData() {

    }
}