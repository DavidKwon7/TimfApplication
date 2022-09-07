package com.example.timfapplication.domain.repository

import com.example.timfapplication.domain.entity.community.RequestModel
import com.example.timfapplication.domain.entity.community.ResponseModel
import retrofit2.Call

interface Repository {

    suspend fun postCommunity(requestModel: RequestModel): Call<ResponseModel>

}