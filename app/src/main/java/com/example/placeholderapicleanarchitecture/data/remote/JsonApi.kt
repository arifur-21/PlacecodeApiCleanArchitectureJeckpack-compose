package com.example.placeholderapicleanarchitecture.data.remote

import com.example.placeholderapicleanarchitecture.data.model.ApiResponsDto
import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface JsonApi {

    @GET("posts")
    suspend fun getAllPost(): List<ApiResponsDto>

    @GET("posts/{id}")
    suspend fun getPostById(
        @Path("id") id: String
    ): ApiResponsDto

    @POST("posts")
    suspend fun postData(@Body apiRespons: ApiRespons): Response<ApiRespons>
}