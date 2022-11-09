package com.example.composejsonapi.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    val BASE_URL ="https://jsonplaceholder.typicode.com/"

    fun RetrofitInstance() :RetrofitInterface{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(RetrofitInterface::class.java)
    }
}