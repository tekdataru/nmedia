package ru.netology.nmedia.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.R
import ru.netology.databinding.ActivityMainBinding
import ru.netology.databinding.CardPostBinding
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Так делается без binding+
//
//        setContentView(R.layout.activity_main)
//
//        findViewById<ImageButton>(R.id.likesImage).setOnClickListener{//println("Clicked!")
//            if (it !is ImageButton) {
//                return@setOnClickListener
//            }
//            it.setImageResource(R.drawable.ic_like_24)}
//        Так делается без binding-
//
//        Так делается c binding+
//        Чтобы включить биндинг надо в build.gradle в разделе андроид после
//        defaultConfig перед buildTypes написать: buildFeatures.viewBinding = true
        /*     val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelLazy: PostViewModel by viewModels()
        viewModelLazy.data.observe(this) { post ->

            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                likesText.text = stringNumberWithKInsteadOf1000(post.likes)
                sharesText.text = stringNumberWithKInsteadOf1000(post.shares)

                likesImage.setImageResource(
                    if (post.likedByMe) R.drawable.ic_like_24 else R.drawable.ic_like_border_24
                )

            }

            binding.likesImage.setOnClickListener{
                viewModelLazy.onClickLike()
            }

            binding.sharesImage.setOnClickListener{
                viewModelLazy.onClickShare()
            }

        }


        //22.05.2022 Сделал ветку mvvm


        //Так делается с binding-
    }*/




        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
//        viewModel.data.observe(this) { posts ->
//            posts.map { post ->
//                CardPostBinding.inflate(layoutInflater, binding.container, true).apply {
//                    author.text = post.author
//                    published.text = post.published
//                    content.text = post.content
//                    likesImage.setImageResource(
//                        if (post.likedByMe) R.drawable.ic_like_24 else R.drawable.ic_like_border_24
//                    )
//                    likesImage.setOnClickListener {
//                        viewModel.likeById(post.id)
//                    }
//                }.root
//
//            }
//
//        }
        val adapter = PostsAdapter{
            viewModel.likeById(it.id)
            viewModel.shareById(it.id)
        }

        binding.list.adapter = adapter
        viewModel.data.observe(this) { posts ->
            //adapter.list = posts}
            adapter.submitList(posts)
        }
    }
}