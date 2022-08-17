package com.example.book_store_app.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("displayValue")
    val displayValue: String,
    @SerializedName("value")
    val value: Double
) : Parcelable