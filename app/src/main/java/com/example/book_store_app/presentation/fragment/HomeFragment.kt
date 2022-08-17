package com.example.book_store_app.presentation.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.book_store_app.data.State
import com.example.book_store_app.data.models.BooksItem
import com.example.book_store_app.data.models.Books
import com.example.book_store_app.data.repository.BookStoreRepositoryImb
import com.example.book_store_app.data.services.BookStoreService
import com.example.book_store_app.databinding.FragmentHomeBinding
import com.example.book_store_app.presentation.adapter.HomeAdpter
import com.example.book_store_app.presentation.base.BaseFragment
import com.example.book_store_app.presentation.interfaces.ItemListener
import com.example.book_store_app.util.extention.navigateTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(), ItemListener {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {
        getBookListItems()
    }


    override fun onClickItem(book: BooksItem) {
        requireActivity().navigateTo(DetailsFragment.newInstance(book))
    }



    private fun getBookListItems() {
        val bookstoreRepositoryImp = BookStoreRepositoryImb(BookStoreService)
  lifecycleScope.launch(Dispatchers.Main) {bookstoreRepositoryImp.getBookFromList().collect(::onGetResponse) }
    }

    private fun onGetResponse(state: State<Books>) {
        when (state) {
            is State.Fail -> onFail(state.message)
            State.Loading -> onLoading()
            is State.Success -> onSuccess(state.data)
        }
    }



    private fun onSuccess(items: List<BooksItem>) {
        val bookStoreAdapter = HomeAdpter(items, this)
        binding.bookStoreRecyclerView.adapter = bookStoreAdapter
        hideLoadingAndHideErrorView()
    }
    private fun onLoading() {
        showLoadingAndHideErrorView()
    }

    private fun onFail(message: String) {
        showMessage(message)
        hideLoadingAndShowErrorView()
    }

    private fun showMessage(msg: String) {
        Toast.makeText(this.context, msg, Toast.LENGTH_SHORT).show()
    }
    private fun hideLoadingAndHideErrorView() {
        binding.apply {
            nointernet.visibility = View.INVISIBLE
            loading.visibility = View.INVISIBLE
        }
    }

    private fun showLoadingAndHideErrorView() {
        binding.apply {
            nointernet.visibility = View.INVISIBLE
            loading.visibility = View.VISIBLE
        }
    }

    private fun hideLoadingAndShowErrorView() {
        binding.apply {
            loading.visibility = View.INVISIBLE
            nointernet.visibility = View.VISIBLE
        }
    }


}