package com.example.placeholderapicleanarchitecture.presentation.post_api

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons
import com.example.placeholderapicleanarchitecture.domain.use_case.PostDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PostDataViewModel @Inject constructor(
private val postDataUseCase: PostDataUseCase
): ViewModel() {

    private val _state = mutableStateOf(ApiResponsState())
    val state : State<ApiResponsState> = _state

    fun onEvent(event: PostDataEvent){
        when(event){
            is PostDataEvent.ChanteTitle->{
                _state.value = state.value.copy(
                    title = event.title

                )
            }
            is PostDataEvent.ChangeBody->{
                _state.value = state.value.copy(
                    body = event.body
                )
            }
            is PostDataEvent.ChangeId->{
                _state.value = state.value.copy(
                    id = event.id
                )
            }
            is PostDataEvent.postDataBtn->{
                viewModelScope.launch {

                    try {
                        postDataUseCase(
                            ApiRespons(
                                title = state.value.title,
                                body = state.value.body,
                              id = 102,
                                userId = 1
                            )
                        )
                       Log.e("tag", "Button Click")
                    }catch (e: java.lang.Exception){

                    }
                }
            }
        }
    }
}