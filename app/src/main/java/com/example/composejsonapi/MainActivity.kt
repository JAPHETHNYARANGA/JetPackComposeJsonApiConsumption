package com.example.composejsonapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composejsonapi.domain.CommentsModel
import com.example.composejsonapi.presentation.CommentsViewModel
import com.example.composejsonapi.ui.theme.ComposeJsonApiTheme

class MainActivity : ComponentActivity() {
    val commentsViewModel by viewModels<CommentsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeJsonApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CommentList(commentList = commentsViewModel.commentsViewResponse)
                    commentsViewModel.getCommentsList()
                }
            }
        }
    }
}

@Composable
fun CommentList(commentList : List<CommentsModel>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn{
        itemsIndexed(items = commentList){index, item ->
            CommentsItem(comment = item, index, selectedIndex){i->
                selectedIndex = i
            }
        }
    }
}
@Composable
fun CommentsItem(){
    val comment = CommentsModel(
        1,
        2,
        "japheth",
        "wycliffe@gmail.com",
        "steve",

    )
    CommentsItem(comment = comment, 0,0){i ->

    }
}

@Composable
fun CommentsItem(comment : CommentsModel, index : Int, selectedIndex:Int, onClick : (Int) -> Unit){

    val backgroudColor = if(index == selectedIndex)MaterialTheme.colors.primary else MaterialTheme.colors.background
    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .fillMaxWidth()
        .clickable { onClick(index) }
        .height(300.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp) {
            Surface(color = backgroudColor) {
                Row(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()) {
                    Column(verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)) {

                        Text(text = comment.id.toString(),
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Normal
                        )
                        Text(text = comment.name,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal
                        )
                        Text(text = comment.email,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal
                        )
                        Text(text = comment.body,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }

        }

    }
}


