package ru.netology.nmedia.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.data.PostRepository
import ru.netology.nmedia.data.impl.PostRepositoryInMemoryImpl
import ru.netology.nmedia.dto.Post

private val empty = Post(
    id = 0,
    content = "",
    author = "",
    likedByMe = false,
    published = ""
)

class PostViewModel : ViewModel() {

    //Упрощенный вариант создания репозитория
//    private val repository:PostRepository = PostRepositoryInMemoryImpl()
//
//    val data get() = repository.data
//
//    fun onClickLike() = repository.like()
//    fun onClickShare() = repository.share()

    //Упрощенный вариант
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.getAll()
    val edited = MutableLiveData(empty)

    fun likeById(id: Long) = repository.likeById(id)
    fun shareById(id: Long) = repository.shareById(id)
    fun removeById(id: Long) = repository.removeById(id)

    fun save() {
        edited.value?.let {
            repository.save(it)

            edited.value = empty
        }

    }

    fun edit(post: Post) {
        edited.value = post
    }

    fun changeContent(content: String) {
        if (content.isBlank()){
            return
        }

        edited.value?.let {
            edited.value = it.copy(content = content)
        }
    }
}