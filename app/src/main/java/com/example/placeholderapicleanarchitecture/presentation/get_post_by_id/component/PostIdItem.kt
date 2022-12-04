package com.example.placeholderapicleanarchitecture.presentation.get_post_by_id.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.placeholderapicleanarchitecture.presentation.get_json_api.component.PostItem
import com.example.placeholderapicleanarchitecture.presentation.get_post_by_id.GetPostByIdViewModel

@Composable
fun PostIdItem(
    viewModel: GetPostByIdViewModel = hiltViewModel()
){

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        state.postIdData?.let { data->
            LazyColumn(modifier = Modifier.fillMaxSize()){

                item{
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .padding(16.dp),
                        elevation = 10.dp,
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(text = "${data.id}. ${data.title}", modifier = Modifier
                                    .fillMaxWidth(),
                                    overflow = TextOverflow.Ellipsis,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )

                            }

                            Text(text = data.body, fontSize = 16.sp)
                        }

                    }
                }
            }
        }

        if (state.error.isNotBlank()){
            Text(text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center))
        }

        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }




}