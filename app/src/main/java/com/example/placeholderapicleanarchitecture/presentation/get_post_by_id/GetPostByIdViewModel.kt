package com.example.placeholderapicleanarchitecture.presentation.get_post_by_id

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.placeholderapicleanarchitecture.common.Resource
import com.example.placeholderapicleanarchitecture.domain.use_case.PostByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class GetPostByIdViewModel @Inject constructor(
    private val postByIdUseCase: PostByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(PostApiState())
    val state: State<PostApiState> = _state

    init {
        savedStateHandle.get<String>("id")?.let {postId->
            getPostById(postId)
        }
    }

    fun getPostById(postId: String){
        postByIdUseCase(postId).onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = PostApiState(
                        postIdData = result.data
                    )
                }
                is Resource.Error->{
                    _state.value = PostApiState(
                        error = result.message ?: "An Unexpected error occured"
                    )
                }
                is Resource.Loading->{
                    _state.value = PostApiState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}