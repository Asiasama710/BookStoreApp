package com.example.book_store_app.data.services

import com.example.book_store_app.util.Constant
import okhttp3.*


object RequestHelper {
    fun makeRequest(): Request {
        val url = Constant.API_URL
        return Request.Builder().url(url).build()
    }
}