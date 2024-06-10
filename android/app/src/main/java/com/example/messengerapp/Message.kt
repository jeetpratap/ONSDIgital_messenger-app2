package com.example.messengerapp

data class Message(
    val id: Int,
    val sender: String,
    val receiver: String,
    val content: String,
    val timestamp: String
)
