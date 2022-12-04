package com.example.placeholderapicleanarchitecture.presentation.get_post_by_id.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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


@Composable
fun PostData(
    title: String,
    body: String,
    id: Int
){

    Card(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .padding(16.dp),
        elevation = 10.dp,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "${id}. ${title}", modifier = Modifier
                    .fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            Text(text = body, fontSize = 16.sp)
        }

    }
}