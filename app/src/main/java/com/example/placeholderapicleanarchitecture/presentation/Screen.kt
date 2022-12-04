package com.example.placeholderapicleanarchitecture.presentation

sealed class Screen(val route: String){
    object PostItemScreen: Screen("post_item_screen")
    object PostIdItemScreen: Screen("post_id_item_screen")
    object PostDataScreen: Screen("post-data_screen")
}
