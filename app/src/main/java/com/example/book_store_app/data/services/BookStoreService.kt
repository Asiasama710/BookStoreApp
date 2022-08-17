package com.example.book_store_app.data.services

import com.example.book_store_app.data.State
import com.example.book_store_app.data.models.Books
import com.google.gson.Gson
import okhttp3.OkHttpClient


interface BaseBookStoreService {
    fun getBook(): State<Books>

}

object BookStoreService : BaseBookStoreService {
    private val client = OkHttpClient()

    override fun getBook(): State<Books> {
        val response = client.newCall(RequestHelper.makeRequest()).execute()
        return if (response.isSuccessful) {
            Gson().fromJson(response.body?.string(), Books::class.java).run {
                State.Success(this)
            }
        } else {
            State.Fail(response.message)
        }
    }
}