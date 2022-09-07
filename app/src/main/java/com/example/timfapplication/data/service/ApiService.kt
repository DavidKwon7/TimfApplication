package com.example.timfapplication.data.service

import com.example.timfapplication.domain.entity.community.RequestModel
import com.example.timfapplication.domain.entity.community.ResponseModel
import com.example.timfapplication.domain.entity.login.RequestLoginModel
import com.example.timfapplication.domain.entity.login.ResponseLoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("v1/signIn")
    fun postLogin(
        @Body requestLoginModel: RequestLoginModel
    ): Call<ResponseLoginModel>


    @POST("v1/free-boards/Dt")
    fun postCommunity(
        @Body boardRequestModel: RequestModel
    ): Call<ResponseModel>

}