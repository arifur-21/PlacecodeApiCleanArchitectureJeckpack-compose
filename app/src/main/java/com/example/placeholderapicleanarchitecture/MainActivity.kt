package com.example.placeholderapicleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.placeholderapicleanarchitecture.domain.model.ApiRespons
import com.example.placeholderapicleanarchitecture.presentation.Screen
import com.example.placeholderapicleanarchitecture.presentation.get_json_api.component.PostScreen
import com.example.placeholderapicleanarchitecture.presentation.get_post_by_id.component.PostData
import com.example.placeholderapicleanarchitecture.presentation.get_post_by_id.component.PostIdItem
import com.example.placeholderapicleanarchitecture.presentation.post_api.PostDataScreens


import com.example.placeholderapicleanarchitecture.ui.theme.PlaceholderApiCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaceholderApiCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.PostItemScreen.route){
                        composable(route = Screen.PostItemScreen.route){
                            PostScreen(navController)
                        }
                        composable(route = Screen.PostIdItemScreen.route + "/{id}"){
                            PostIdItem()
                        }

                        composable(route = Screen.PostDataScreen.route){
                    PostDataScreens()
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlaceholderApiCleanArchitectureTheme {
        Greeting("Android")
    }
}