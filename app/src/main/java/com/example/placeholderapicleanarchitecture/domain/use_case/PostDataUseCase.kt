package com.example.placeholderapicleanarchitecture.domain.use_case

import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons
import com.example.placeholderapicleanarchitecture.domain.repository.JsonRepository
import javax.inject.Inject

class PostDataUseCase @Inject constructor(
    private val jsonRepository: JsonRepository
) {

   suspend operator fun invoke(apiRespons: ApiRespons){
        jsonRepository.postData(apiRespons)
    }

}