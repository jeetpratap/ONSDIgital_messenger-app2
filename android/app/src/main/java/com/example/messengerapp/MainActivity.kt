package com.example.messengerapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageTextView: TextView = findViewById(R.id.message_text)

        RetrofitClient.instance.getMessages().enqueue(object : Callback<List<Message>> {
            override fun onResponse(call: Call<List<Message>>, response: Response<List<Message>>) {
                if (response.isSuccessful) {
                    val messages = response.body()
                    messages?.let {
                        val messageContent = it.joinToString("\n") { message -> "${message.sender}: ${message.content}" }
                        messageTextView.text = messageContent
                    }
                }
            }

            override fun onFailure(call: Call<List<Message>>, t: Throwable) {
                messageTextView.text = "Failed to load messages"
            }
        })
    }
}
