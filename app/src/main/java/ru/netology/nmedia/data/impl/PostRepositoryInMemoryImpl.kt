package ru.netology.nmedia.data.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.data.PostRepository
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

    private val post:Post = Post(
        id = 1,
        author = "Нетология. Университет интернет-профессий будущего",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработки, аналитике и управлению. Мы растем сами и помогаем расти студентам: от новичков до уверенных профессионалов.",
        published = "20 мая в 19:13",
        likes = 99,
        shares = 985
    )


    override var data = MutableLiveData(post)

    //override fun get(): LiveData<Post> = data

    override fun like() {


        data.value = post.copy(
            //likes = if (post.likedByMe) post.likes - 1 else post.likes + 1,
            likedByMe = !post.likedByMe
        )
    }
}