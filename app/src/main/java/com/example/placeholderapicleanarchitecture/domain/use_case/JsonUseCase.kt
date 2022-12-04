package com.example.placeholderapicleanarchitecture.domain.use_case

import com.example.placeholderapicleanarchitecture.common.Resource
import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons
import com.example.placeholderapicleanarchitecture.domain.repository.JsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class JsonUseCase @Inject constructor(
    private val repository: JsonRepository
) {

    operator fun invoke(): Flow<Resource<List<ApiRespons>>> = flow{

     try {
         emit(Resource.Loading())
         val respons = repository.getAllPost().map { it.toApiRespons() }
         emit(Resource.Success(respons))
     }catch (e: HttpException){
         emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
     }catch (e: IOException){
         emit(Resource.Error("Check internet connection"))
     }


    }
}