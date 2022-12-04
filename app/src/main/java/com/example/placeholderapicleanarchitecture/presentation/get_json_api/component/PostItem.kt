package com.example.placeholderapicleanarchitecture.presentation.get_json_api.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons

@Composable
fun PostItem(
    onItemClick: (ApiRespons)-> Unit,
    apiRespons: ApiRespons,
){

    Card(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .clickable { onItemClick(apiRespons) }
        .padding(16.dp),
        elevation = 10.dp,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "${apiRespons.id}. ${apiRespons.title}", modifier = Modifier
                    .fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

            }

        }

    }
}