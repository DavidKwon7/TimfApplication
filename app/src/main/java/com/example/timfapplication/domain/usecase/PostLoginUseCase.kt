package com.example.timfapplication.domain.usecase

import com.example.timfapplication.domain.entity.login.RequestLoginModel
import com.example.timfapplication.domain.entity.login.ResponseLoginModel
import com.example.timfapplication.domain.repository.Repository
import retrofit2.Call
import javax.inject.Inject

class PostLoginUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun invoke(requestLoginModel: RequestLoginModel): Call<ResponseLoginModel> {
        return repository.postLogin(requestLoginModel)
    }
}