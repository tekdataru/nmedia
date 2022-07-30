package ru.netology.nmedia.ui

import android.content.Context
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.internal.ContextUtils
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import ru.netology.R
import ru.netology.nmedia.dto.Post
import kotlin.random.Random




class PushSender {

   fun sendPushLikeTest(someContext: Context?, post: Post){
       //Эта функция показывает тост и уведомление по нажатию на лайк
       //Пока что отключим ее
       return

        Toast.makeText(someContext, "Like on post (id ${post.id})!", Toast.LENGTH_LONG).show()
            val channelId = "remote"

       val sccc = (someContext as Context)
       sccc.let {

           val notification = NotificationCompat.Builder(it, channelId)
               .setSmallIcon(R.drawable.ic_notification)
               .setContentTitle(
                   "It is Like! (or unlike)"
               )
               .setPriority(NotificationCompat.PRIORITY_DEFAULT)
               .build()
           NotificationManagerCompat.from(it)
                .notify(Random.nextInt(100_000), notification)}

    }

    fun sendPushLike(){

//        val token = "111"
//
//        val options = FirebaseOptions.builder()
//            .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
//            .build()
//        FirebaseApp.initializeApp(options)
//        val message = Message.builder()
//            .putData("action", "LIKE")
//            .putData("content", """{
//          "userId": 1,
//          "userName": "Vasiliy",
//          "postId": 2,
//          "postAuthor": "Netology"
//        }""".trimIndent())
//            .setToken(token)
//            .build()
//
//        FirebaseMessaging.getInstance().send(message)
    }
}