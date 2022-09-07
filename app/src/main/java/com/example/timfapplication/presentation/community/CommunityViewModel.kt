package com.example.timfapplication.presentation.community

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timfapplication.domain.entity.community.RequestModel
import com.example.timfapplication.domain.entity.community.ResponseModel
import com.example.timfapplication.domain.usecase.PostCommunityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val postCommunityUseCase: PostCommunityUseCase
) : ViewModel() {

    private var _communityLiveData = MutableLiveData<ResponseModel>()
    val boardLiveData: LiveData<ResponseModel> get() = _communityLiveData

    fun postData(requestModel: RequestModel) = viewModelScope.launch(Dispatchers.IO) {
        postCommunityUseCase.invoke(requestModel).enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                _communityLiveData.postValue(response.body())
                Timber.d("onResponse: " + response.body() + ")")
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}