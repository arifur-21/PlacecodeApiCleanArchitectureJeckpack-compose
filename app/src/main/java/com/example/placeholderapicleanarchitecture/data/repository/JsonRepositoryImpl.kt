package com.example.placeholderapicleanarchitecture.data.repository

import com.example.placeholderapicleanarchitecture.data.model.ApiResponsDto
import com.example.placeholderapicleanarchitecture.data.remote.JsonApi
import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons
import com.example.placeholderapicleanarchitecture.domain.repository.JsonRepository
import retrofit2.Response
import javax.inject.Inject

class JsonRepositoryImpl @Inject constructor(
    private val jsonApi: JsonApi
) : JsonRepository{
    override suspend fun getAllPost(): List<ApiResponsDto> {
        return jsonApi.getAllPost()
    }

    override suspend fun getPostById(id: String): ApiResponsDto {
        return jsonApi.getPostById(id)
    }

    override suspend fun postData(apiRespons: ApiRespons): Response<ApiRespons> {
        return jsonApi.postData(apiRespons)
    }


}