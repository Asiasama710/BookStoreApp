package com.example.book_store_app.data.repository


import com.example.book_store_app.data.State
import com.example.book_store_app.data.models.Books
import com.example.book_store_app.data.services.BaseBookStoreService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


interface BooksRepository {
    fun getBookFromList(): Flow<State<Books>>
}

class BookStoreRepositoryImb(private val bookStoreService: BaseBookStoreService) : BooksRepository {
    override fun getBookFromList(): Flow<State<Books>> {
        return flow {
            emit(State.Loading)
            try {
                emit(bookStoreService.getBook())

            } catch (e: Exception) {
                emit(State.Fail(e.message.toString()))
            }

        }.flowOn(Dispatchers.IO)

    }

}