package com.example.book_store_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.book_store_app.data.models.BooksItem
import com.example.book_store_app.databinding.SingleBookBinding
import com.example.book_store_app.presentation.interfaces.ItemListener

class HomeAdpter(private val items: List<BooksItem>, private val itemListener: ItemListener): RecyclerView.Adapter<HomeAdpter.BooksViewHolder>() {

    inner class BooksViewHolder(val binding: SingleBookBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(SingleBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val currentitem = items[position]
        holder.binding.apply {
            bookName.text = currentitem.title
            autherName.text = currentitem.author
            Glide.with(this.root.context).load(currentitem.image).into(bookImage)
            currencyValue.text = currentitem.price.value.toString()
            cardImage.setOnClickListener {
                itemListener.onClickItem(currentitem)
            }
        }
    }



}