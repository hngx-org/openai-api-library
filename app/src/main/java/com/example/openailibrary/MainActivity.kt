package com.example.openailibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apilibrary.wrapperclass.OpenAiCaller
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Note : This is for testing purposes.

//        CoroutineScope(Dispatchers.Main).launch {
//            val response = OpenAiCaller.generateUserChatResponse("What was my last question?",
//                arrayOf("User : What color is an Apple?", "Ai : An Apple is red in color."))
//
//            // Do something with response
//        }
    }
}