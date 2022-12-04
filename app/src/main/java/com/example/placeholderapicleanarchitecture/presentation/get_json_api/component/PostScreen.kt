package com.example.placeholderapicleanarchitecture.presentation.get_json_api.component

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.placeholderapicleanarchitecture.presentation.Screen
import com.example.placeholderapicleanarchitecture.presentation.get_json_api.JsonApiViewModel

@Composable
fun PostScreen(
    navController: NavController,
    viewModel: JsonApiViewModel = hiltViewModel()
){

    val state = viewModel.state.value
Box(modifier = Modifier.fillMaxSize()){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(state.respins){result->
            PostItem(onItemClick = {
               // navController.navigate(Screen.PostIdItemScreen.route + "/${result.id}")
                                   navController.navigate(Screen.PostDataScreen.route)
            }, apiRespons =result )
        }
    }

    if (state.erro.isNotBlank()){
        Text(text = state.erro,
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