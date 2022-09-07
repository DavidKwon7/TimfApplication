package com.example.timfapplication.domain.entity.community

import com.google.gson.annotations.SerializedName

data class RequestModel(
    @SerializedName("length")
    val length: Int?,
    @SerializedName("searchObj")
    val searchObj: SearchObj?,
    @SerializedName("start")
    val start: Int?
)

data class SearchObj(
    @SerializedName("boardCn")
    val boardCn: String?,
    @SerializedName("boardSj")
    val boardSj: String?,
    @SerializedName("boardTy")
    val boardTy: String?,
    @SerializedName("creatDEnd")
    val creatDEnd: String?,
    @SerializedName("creatDStart")
    val creatDStart: String?,
    @SerializedName("wrterLoginId")
    val wrterLoginId: String?,
    @SerializedName("wrterNcnm")
    val wrterNcnm: String?
)
