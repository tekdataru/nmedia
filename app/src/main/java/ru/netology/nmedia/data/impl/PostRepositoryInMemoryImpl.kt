package ru.netology.nmedia.data.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.data.PostRepository
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

//    private var post:Post = Post(
//        id = 1,
//        author = "Нетология. Университет интернет-профессий будущего",
//        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработки, аналитике и управлению. Мы растем сами и помогаем расти студентам: от новичков до уверенных профессионалов.",
//        published = "20 мая в 19:13",
//        likes = 999,
//        shares = 985
//    )

    private var posts = listOf(
        Post(
            id = 2,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Знаний хватит на всех: разберемся!",
            published = "30 мая в 23:13",
            likes = 2,
            shares = 3
        ),
        Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработки, аналитике и управлению. Мы растем сами и помогаем расти студентам: от новичков до уверенных профессионалов.",
            published = "20 мая в 19:13",
            likes = 999,
            shares = 985
        ),
        Post(
            id = 3,
            author = "33Нетология. Университет интернет-профессий будущего",
            content = "33Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработки, аналитике и управлению. Мы растем сами и помогаем расти студентам: от новичков до уверенных профессионалов.",
            published = "3320 мая в 19:13",
            likes = 999,
            shares = 985
        ),


    )


    private val data = MutableLiveData(posts)
    override fun getAll(): LiveData<List<Post>> = data

//    override fun like() {
//
//        post = post.copy(
//            likes= post.likes + if (post.likedByMe) -1 else 1,
//            likedByMe = !post.likedByMe
//        )
//
//        data.value = post
//
//    }
//
//    override fun share() {
//        post = post.copy(
//            shares = post.shares + 1
//        )
//
//        data.value = post
//    }

    override fun likeById(id: Long) {
        posts = posts.map{
            if (it.id != id) it else it.copy(likedByMe = !it.likedByMe)
        }

        data.value = posts
    }
}