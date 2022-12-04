package com.example.placeholderapicleanarchitecture.presentation.get_post_by_id

import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons

data class PostApiState (
    val isLoading: Boolean = false,
    val postIdData: ApiRespons? = null,
    val error: String = ""
        )