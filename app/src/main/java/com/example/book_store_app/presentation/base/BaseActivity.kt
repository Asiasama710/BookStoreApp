package com.example.book_store_app.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.book_store_app.R


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    abstract fun setup()
    abstract val inflate: (LayoutInflater) -> VB
    private lateinit var _binding: VB
    protected val binding: VB
        get() = _binding


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Book_Store_App)
        super.onCreate(savedInstanceState)
        _binding = inflate(layoutInflater)
        setContentView(_binding.root)
        setup()

    }


}