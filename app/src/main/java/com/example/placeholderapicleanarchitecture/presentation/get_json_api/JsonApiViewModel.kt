package com.example.placeholderapicleanarchitecture.presentation.get_json_api

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.placeholderapicleanarchitecture.common.Resource
import com.example.placeholderapicleanarchitecture.domain.use_case.JsonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class JsonApiViewModel @Inject constructor(
    private val jsonUseCase: JsonUseCase
): ViewModel() {

    private val _state = mutableStateOf(JsonApiState())
    val state: State<JsonApiState> = _state

    init {
        getAllPost()
    }

    fun getAllPost(){
        jsonUseCase().onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = JsonApiState(respins = result.data ?: emptyList())
                }
                is Resource.Error->{
                    _state.value = JsonApiState(erro = result.message?: "An unexpected error occured")
                }
                is Resource.Loading->{
                    _state.value = JsonApiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}