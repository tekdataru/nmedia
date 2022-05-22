package ru.netology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

class MainActivity : AppCompatActivity() {
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

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработки, аналитике и управлению. Мы растем сами и помогаем расти студентам: от новичков до уверенных профессионалов.",
            published = "20 мая в 19:13",
            likes = 999999,
            shares = 985
        )

        with (binding){
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likesText.text = stringNumberWithKInsteadOf1000(post.likes)
            sharesText.text  = stringNumberWithKInsteadOf1000(post.shares)

            if (post.likedByMe){
                likesImage?.setImageResource(R.drawable.ic_like_border_24)
            }

            likesImage?.setOnClickListener{

                if (post.likedByMe) {
                    post.likes--
                } else {
                    post.likes++
                }

                post.likedByMe = !post.likedByMe

                likesImage.setImageResource(
                    if (post.likedByMe) {
                        R.drawable.ic_like_24
                    } else {
                        R.drawable.ic_like_border_24
                    }
                )
                likesText.text = stringNumberWithKInsteadOf1000(post.likes)
            }

            sharesImage?.setOnClickListener {
                post.shares++

                sharesText.text = stringNumberWithKInsteadOf1000(post.shares)
            }

        }

    //22.05.2022 Сделал ветку mvvm


        //Так делается с binding-
    }

    fun stringNumberWithKInsteadOf1000(i:Int):String{
        if (i > 999_999_999_999) return ">1T!"

        var iTemp:Int = i / 1_000_000_000
        if (iTemp > 0) return "" + iTemp + "B"

        iTemp = i / 1_000_000
        if (iTemp > 0) return "" + iTemp + "M"

        iTemp = i / 1_000
        if (iTemp > 0) return "" + iTemp + "K"

        return "" + i
    }


}