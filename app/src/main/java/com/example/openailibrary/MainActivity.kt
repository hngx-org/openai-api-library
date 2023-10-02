package com.example.openailibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apilibrary.wrapperclass.OpenAiCaller
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val testArray = arrayOf(
//            "user: Hello!",
//            "AI: Hi! How can I help you today?",
//            "user: I'm looking for information on the latest trends in artificial intelligence.",
//            "AI: Sure, here are some of the latest trends in artificial intelligence"
//        )
//
//        // Important Note! This is only for testing the response directly from the project. This is not implementing the code in terms of a 'library'
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = OpenAiCaller.generateResponse("What is a fish?", testArray)
//            Log.i(TAG, "Received Response is $response")
//        }

    }
}