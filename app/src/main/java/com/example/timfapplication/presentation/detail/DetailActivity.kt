package com.example.timfapplication.presentation.detail

import android.os.Bundle
import com.example.timfapplication.R
import com.example.timfapplication.databinding.ActivityDetailBinding
import com.example.timfapplication.presentation.base.BaseActivity

class DetailActivity : BaseActivity<ActivityDetailBinding>({ ActivityDetailBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getIntentData()
    }

    private fun getIntentData() = with(binding) {
        val name = intent.getStringExtra("title").toString()
        val url = intent.getStringExtra("content").toString()

        tvTitle.text = name
        tvDescription.text = url
    }
}