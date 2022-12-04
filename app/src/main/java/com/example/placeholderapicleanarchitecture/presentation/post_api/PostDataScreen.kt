package com.example.placeholderapicleanarchitecture.presentation.post_api

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PostDataScreens(
    viewModel: PostDataViewModel = hiltViewModel()
){

    val state = viewModel.state.value

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        OutlinedTextField(value =state.title, onValueChange = {
            viewModel.onEvent(PostDataEvent.ChanteTitle(it))
            Log.e("tag", "postScreen ${state.title}")
        },
            placeholder = { Text(text = "Enter your Title") },
            label = { Text(text = "Title") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = state.body, onValueChange = {
            viewModel.onEvent(PostDataEvent.ChangeBody(it))
        },
            placeholder = { Text(text = "Enter your body") },
            label = { Text(text = "body") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = "", onValueChange = {
         //   viewModel.onEvent(PostDataEvent.ChangeId(it))
        },
            placeholder = { Text(text = "Enter your id") },
            label = { Text(text = "Id") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.onEvent(PostDataEvent.postDataBtn)
        }) {
            Text(text = "Post DAta")
        }
    }
}