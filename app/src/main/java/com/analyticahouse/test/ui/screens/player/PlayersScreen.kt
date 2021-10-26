package com.analyticahouse.test.ui.screens.player

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.analyticahouse.test.ui.navigation.Screen

@Composable
fun PlayersScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val text by remember {
                mutableStateOf("2")
            }

            Button(
                onClick = {
                   // navController.navigate(Screen.PlayerDetailScreen.withArgs(text))
                }
            ) {
                Text(text = "Go To Player Detail Screen")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                   // navController.navigate(Screen.FavoritePlayersScreen.route)
                }
            ) {
                Text(text = "Go To Favorite Players Screen")
            }
        }
    }
}