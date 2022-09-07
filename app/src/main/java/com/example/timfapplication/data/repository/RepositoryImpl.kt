package com.example.timfapplication.data.repository

import com.example.timfapplication.data.service.ApiService
import com.example.timfapplication.domain.entity.community.RequestModel
import com.example.timfapplication.domain.entity.community.ResponseModel
import com.example.timfapplication.domain.repository.Repository
import retrofit2.Call
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {
    override suspend fun postCommunity(requestModel: RequestModel): Call<ResponseModel> {
        return apiService.postCommunity(requestModel)
    }
}