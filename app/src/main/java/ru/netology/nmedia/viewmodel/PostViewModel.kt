package ru.netology.nmedia.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.data.PostRepository
import ru.netology.nmedia.data.impl.PostRepositoryInMemoryImpl

class PostViewModel: ViewModel() {

    //Упрощенный вариант создания репозитория
    private val repository:PostRepository = PostRepositoryInMemoryImpl()

    val data get() = repository.data

    fun onClickLike() = repository.like()
    fun onClickShare() = repository.share()
}