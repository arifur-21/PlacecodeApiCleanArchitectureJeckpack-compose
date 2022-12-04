package com.example.placeholderapicleanarchitecture.data.model

import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons

data class ApiResponsDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
){
    fun toApiRespons(): ApiRespons{
        return ApiRespons(
            body = body,
            id = id,
            title = title,
            userId = userId
        )
    }
}