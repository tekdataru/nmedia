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
import java.io.FileInputStream
import kotlin.random.Random
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.messaging.Message


class PushSender {

   fun sendPushLikeTest(someContext: Context?, post: Post){
        Toast.makeText(someContext, "Like on post (id ${post.id})!", Toast.LENGTH_LONG).show()
            val channelId = "remote"

       val sccc = (someContext as Context)
       sccc.let {

           val notification = NotificationCompat.Builder(it, channelId)
               .setSmallIcon(R.drawable.ic_notification)
               .setContentTitle(
                   "asdfasdf!"
               )
               .setPriority(NotificationCompat.PRIORITY_DEFAULT)
               .build()
           NotificationManagerCompat.from(it)
                .notify(Random.nextInt(100_000), notification)}
       sendPushLike()
    }

    fun sendPushLike(){
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
            .build()
        FirebaseApp.initializeApp(options)
        val message = Message.builder()
            .putData("action", "LIKE")
            .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
            .setToken(token)
            .build()

        FirebaseMessaging.getInstance().send(message)
    }
}