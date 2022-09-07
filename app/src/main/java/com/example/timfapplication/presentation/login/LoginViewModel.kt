package com.example.timfapplication.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timfapplication.domain.entity.login.RequestLoginModel
import com.example.timfapplication.domain.entity.login.ResponseLoginModel
import com.example.timfapplication.domain.repository.Repository
import com.example.timfapplication.domain.usecase.PostLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val postLoginUseCase: PostLoginUseCase
) : ViewModel() {

    val TAG = "vmTest"

    fun postLogin(requestLoginModel: RequestLoginModel) = viewModelScope.launch(Dispatchers.IO) {
        postLoginUseCase.invoke(requestLoginModel).enqueue(object : retrofit2.Callback<ResponseLoginModel> {
            override fun onResponse(
                call: Call<ResponseLoginModel>,
                response: Response<ResponseLoginModel>
            ) {
                Timber.tag(TAG).d("res")
                Timber.tag(TAG).d("onResponse: %s", response.body())
            }

            override fun onFailure(call: Call<ResponseLoginModel>, t: Throwable) {
                Timber.tag(TAG).d("error")
                t.printStackTrace()
            }
        })
    }
}