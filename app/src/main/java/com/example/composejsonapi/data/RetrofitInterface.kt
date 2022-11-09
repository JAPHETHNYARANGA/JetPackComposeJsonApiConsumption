package com.example.composejsonapi.data

import com.example.composejsonapi.domain.CommentsModel
import retrofit2.http.GET

interface RetrofitInterface{
    @GET("comments")
    suspend fun getComments() : List<CommentsModel>
}