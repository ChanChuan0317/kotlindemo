package com.chanchuan.kotlindemo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.item_gank.*

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        val stringExtra = intent.getStringExtra("girl")
        sdv_image.setImageURI(Uri.parse(stringExtra))
        sdv_image.setOnClickListener {
            finish()
        }
    }
}