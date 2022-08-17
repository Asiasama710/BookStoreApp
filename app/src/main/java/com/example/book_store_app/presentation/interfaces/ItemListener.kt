package com.example.book_store_app.presentation.interfaces

import com.example.book_store_app.data.models.BooksItem

interface ItemListener {
    fun onClickItem(book: BooksItem)
}