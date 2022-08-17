package com.example.book_store_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import com.example.book_store_app.R
import com.example.book_store_app.databinding.ActivityMainBinding
import com.example.book_store_app.presentation.base.BaseActivity
import com.example.book_store_app.presentation.fragment.HomeFragment
import com.example.book_store_app.util.extention.navigateTo

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val inflate: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setup() {
      navigateTo(HomeFragment())
    }
}