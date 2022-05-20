package com.example.fishermenhandbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*

class ContentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        tvTitle_NewAct.text = intent.getStringExtra("title")
        tvContent_NewAct.text = intent.getStringExtra("content")
        image_NewAct.setImageResource(intent.getIntExtra("image",R.drawable.fish1))

    }
}