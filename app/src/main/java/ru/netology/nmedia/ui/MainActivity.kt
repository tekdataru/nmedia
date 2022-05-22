package ru.netology.nmedia.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.R
import ru.netology.databinding.ActivityMainBinding
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    private var tempCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Так делается без binding+

//        setContentView(R.layout.activity_main)
//
//        findViewById<ImageButton>(R.id.likesImage).setOnClickListener{//println("Clicked!")
//            if (it !is ImageButton) {
//                return@setOnClickListener
//            }
//            it.setImageResource(R.drawable.ic_like_24)}
        //Так делается без binding-

        //Так делается c binding+
        //Чтобы включить биндинг надо в build.gradle в разделе андроид после
        //defaultConfig перед buildTypes написать: buildFeatures.viewBinding = true
        val binding = ActivityMainBinding.inflate(layoutInflater)
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

                //likesText.text = stringNumberWithKInsteadOf1000(post.likes)


                sharesImage.setOnClickListener {
                    //post.shares++

                    sharesText.text = stringNumberWithKInsteadOf1000(post.shares)
                }

            }

            binding.likesImage.setOnClickListener{
                viewModelLazy.onClickLike()
                binding.viewsText.text = "" + (tempCount++)

//                    if (post.likedByMe) {
//                        post.likes--
//                    } else {
//                        post.likes++
//                    }

//                    post.likedByMe = !post.likedByMe


            }

        }


        //22.05.2022 Сделал ветку mvvm


        //Так делается с binding-
    }

    fun stringNumberWithKInsteadOf1000(i: Int): String {
        if (i > 999_999_999_999) return ">1T!"

        var iTemp: Int = i / 1_000_000_000
        if (iTemp > 0) return "" + iTemp + "B"

        iTemp = i / 1_000_000
        if (iTemp > 0) return "" + iTemp + "M"

        iTemp = i / 1_000
        if (iTemp > 0) return "" + iTemp + "K"

        return "" + i
    }


}