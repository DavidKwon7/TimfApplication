package com.example.timfapplication.domain.usecase

import com.example.timfapplication.domain.entity.community.RequestModel
import com.example.timfapplication.domain.entity.community.ResponseModel
import com.example.timfapplication.domain.repository.Repository
import retrofit2.Call
import javax.inject.Inject

class PostCommunityUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun invoke(requestModel: RequestModel): Call<ResponseModel> {
        return repository.postCommunity(requestModel)
    }
}