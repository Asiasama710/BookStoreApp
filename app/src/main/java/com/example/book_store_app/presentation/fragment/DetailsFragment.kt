package com.example.book_store_app.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.book_store_app.data.models.BooksItem
import com.example.book_store_app.databinding.FragmentDetailsBinding
import com.example.book_store_app.presentation.base.BaseFragment
import com.example.book_store_app.util.Constant.KEY
import com.example.book_store_app.util.extention.back
class DetailsFragment:BaseFragment<FragmentDetailsBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate

    override fun setup() {

    }

    override fun onStart() {
        super.onStart()
        val book = getbookFromArgument()
        bindView(book)
        addCallback()
    }


    private fun getbookFromArgument(): BooksItem = arguments?.getParcelable(KEY)!!



    private fun bindView(book: BooksItem) {
        binding.apply {
            bookName.text = book.title
            autherName.text = book.author
            currencyValue.text = "${book.price.value} ${book.price.currency}"
            description.text = book.description
            Glide.with(this.root.context).load(book.image).into(bookImage)

        }
    }

    private fun bindViewButton() {
        binding.backButton.setOnClickListener {
            requireActivity().back(this@DetailsFragment)
        }
    }

    fun addCallback() {
        bindViewButton()
    }





    companion object {
        fun newInstance(book: BooksItem) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY, book)
            }
        }
    }


}