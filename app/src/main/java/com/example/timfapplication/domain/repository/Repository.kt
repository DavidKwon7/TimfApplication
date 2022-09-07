package com.example.timfapplication.domain.repository

import com.example.timfapplication.domain.entity.community.RequestModel
import com.example.timfapplication.domain.entity.community.ResponseModel
import com.example.timfapplication.domain.entity.login.RequestLoginModel
import com.example.timfapplication.domain.entity.login.ResponseLoginModel
import retrofit2.Call

interface Repository {

    suspend fun postLogin(requestLoginModel: RequestLoginModel): Call<ResponseLoginModel>

    suspend fun postCommunity(requestModel: RequestModel): Call<ResponseModel>

}