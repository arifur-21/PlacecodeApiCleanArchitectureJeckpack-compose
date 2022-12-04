package com.example.placeholderapicleanarchitecture.presentation.post_api

data class ApiResponsState(
    val title: String = "",
    val body: String = "",
    val id: Int? = null,
    val userId: Int? = null
)
