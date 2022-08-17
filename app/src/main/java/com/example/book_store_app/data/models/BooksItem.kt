package com.example.book_store_app.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class BooksItem(
    @SerializedName("ISBN")
    val id: Long,
    @SerializedName("author")
    val author: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Price,
    @SerializedName("summary")
    val description: String,
    @SerializedName("title")
    val title: String
) : Parcelable
