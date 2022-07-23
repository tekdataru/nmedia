package ru.netology.nmedia.ui

import android.content.Context
import android.widget.Toast
import com.google.android.material.internal.ContextUtils
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import java.io.FileInputStream

class PushSender {

   fun sendPushLikeTest(someContext: Context?){
        Toast.makeText(someContext, "1111!", Toast.LENGTH_LONG).show()

    }

    fun sendPushLike(){
//        val options = FirebaseOptions.builder()
//            .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
//            .build()
//
//        FirebaseApp.initializeApp(options)
//
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