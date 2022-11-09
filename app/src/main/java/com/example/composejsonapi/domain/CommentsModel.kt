package com.example.composejsonapi.domain

data class CommentsModel(
    val postId : Int,
    val id : Int,
    val name : String,
    val email : String,
    val body : String
)
