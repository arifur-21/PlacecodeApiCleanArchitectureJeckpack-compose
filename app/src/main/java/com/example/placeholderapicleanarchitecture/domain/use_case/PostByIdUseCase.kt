package com.example.placeholderapicleanarchitecture.domain.use_case

import com.example.placeholderapicleanarchitecture.common.Resource
import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons
import com.example.placeholderapicleanarchitecture.domain.repository.JsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostByIdUseCase @Inject constructor(
    private val repository: JsonRepository
) {

    operator fun invoke(id: String): Flow<Resource<ApiRespons>> = flow{
       try {

           emit(Resource.Loading())
           val responsId = repository.getPostById(id).toApiRespons()
           emit(Resource.Success(responsId))
       }catch (e: HttpException){
           emit(Resource.Error(e.message() ?: "An unexpected error occured"))
       }catch (e: IOException){
           emit(Resource.Error("check your internet connection"))
       }
    }
}