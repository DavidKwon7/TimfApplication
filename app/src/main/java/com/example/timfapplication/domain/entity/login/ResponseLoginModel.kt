package com.example.timfapplication.domain.entity.login

data class ResponseLoginModel(
    val code: Int,
    val data: String,
    val msg: String,
    val success: Boolean
)
