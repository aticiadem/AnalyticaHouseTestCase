package com.analyticahouse.test.presentation.screens.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.analyticahouse.test.presentation.navigation.Screen

@Composable
fun FavoritesScreen(
    navController: NavController,
    currentScreen: MutableState<String>,
) {
    currentScreen.value = Screen.FavoritesScreen.route
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.navigate(Screen.FavoriteTeamsScreen.route) {
                        popUpTo(Screen.FavoriteTeamsScreen.route) { inclusive = true }
                    }
                }
            ) {
                Text(text = "Go To Favorite Teams Screen")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.FavoritePlayersScreen.route) {
                        popUpTo(Screen.FavoriteTeamsScreen.route) { inclusive = true }
                    }
                }
            ) {
                Text(text = "Go To Favorite Players Screen")
            }
        }
    }
}