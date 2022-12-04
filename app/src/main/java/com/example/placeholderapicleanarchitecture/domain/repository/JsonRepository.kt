package com.example.placeholderapicleanarchitecture.domain.repository

import com.example.placeholderapicleanarchitecture.data.model.ApiResponsDto
import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons
import retrofit2.Response

interface JsonRepository {

    suspend fun getAllPost(): List<ApiResponsDto>
    suspend fun getPostById(id: String): ApiResponsDto
    suspend fun postData(apiRespons: ApiRespons): Response<ApiRespons>
}