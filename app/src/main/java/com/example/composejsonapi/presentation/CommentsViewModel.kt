package com.example.composejsonapi.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejsonapi.data.RetrofitInstance
import com.example.composejsonapi.domain.CommentsModel
import kotlinx.coroutines.launch

class CommentsViewModel : ViewModel(){
    var commentsViewResponse:List<CommentsModel> by mutableStateOf(listOf())
    var errorMessage : String by mutableStateOf("")


     fun getCommentsList(){
        viewModelScope.launch {
            val apiService = RetrofitInstance.RetrofitInstance()

            try {
                val commentsList = RetrofitInstance.RetrofitInstance().getComments()
                commentsViewResponse = commentsList
            }catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }

    }
}