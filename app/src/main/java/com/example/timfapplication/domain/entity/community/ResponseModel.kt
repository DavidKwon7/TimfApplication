package com.example.timfapplication.domain.entity.community

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: List<Data?>?
)

data class Data(

    // 게시글 내용
    @SerializedName("boardCn")
    val boardCn: String?,

    // 게시글 제목
    @SerializedName("boardSj")
    val boardSj: String?,

    // 생성 일시
    @SerializedName("creatDt")
    val creatDt: String?,

    // 작성자 프로필 이미지 경로
    @SerializedName("userProfileFilePth")
    val userProfileFilePth: Any?,

    // 작성자 닉네임
    @SerializedName("wrterNcnm")
    val wrterNcnm: String?,

    @SerializedName("updtDt")
    val updtDt: String?

)
