package com.example.placeholderapicleanarchitecture.presentation.get_json_api

import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons

data class JsonApiState(
    val respins: List<ApiRespons> = emptyList(),
    val isLoading: Boolean = false,
    val erro: String = "",
)
