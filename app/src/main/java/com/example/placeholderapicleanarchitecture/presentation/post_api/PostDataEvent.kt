package com.example.placeholderapicleanarchitecture.presentation.post_api

sealed class PostDataEvent{
    data class ChanteTitle(val title: String): PostDataEvent()
    data class ChangeBody(val body: String): PostDataEvent()
    data class ChangeId(val id: Int): PostDataEvent()
    object postDataBtn: PostDataEvent()
}
