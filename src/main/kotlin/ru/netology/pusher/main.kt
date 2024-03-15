package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main(){
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .setDatabaseUrl(dbUrl)
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

    val messageAdd = Message.builder()
        .putData("action", "ADD")
        .putData("content", """{
            "postId": 2,
            "postAuthor": "Netology",
            "content" : "Line 1\nLine 2\nLine 3\nLine 4\nLine 5\nLine 6\nLine 7\nLine 8\nLine 9\nLine 10\nLine 11\nLine 12\nLine 13\nLine 14\nLine 15\nLine 16\nLine 17\nLine 18\nLine 19\nLine 20"
        }""".trimIndent())
        .setToken(token)
        .build()
    FirebaseMessaging.getInstance().send(messageAdd)

}