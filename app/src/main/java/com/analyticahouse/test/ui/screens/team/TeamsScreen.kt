package com.analyticahouse.test.ui.screens.team

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
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.analyticahouse.test.ui.navigation.Screen
import com.analyticahouse.test.ui.screens.favorite.FavoriteTeamsScreen

@Composable
fun TeamsScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val text by remember {
                mutableStateOf("1")
            }

            Button(
                onClick = {
                    /*navController.navigate(Screen.TeamDetailScreen.withArgs(text)) {
                        popUpTo(Screen.TeamDetailScreen.route) { inclusive = true }
                    }*/
                }
            ) {
                Text(text = "Go To Team Detail Screen")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    //navController.navigate(Screen.FavoriteTeamsScreen.route)
                }
            ) {
                Text(text = "Go To Favorite Teams Screen")
            }
        }
    }
}

@Composable
fun TeamsNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.TeamsScreen.route) {
        composable(route = Screen.TeamsScreen.route) {
            TeamsScreen()
        }
        composable(
            route = Screen.TeamDetailScreen.route + "/{teamId}",
            arguments = listOf(
                navArgument("teamId") {
                    type = NavType.StringType
                    defaultValue = "1"
                }
            )
        ) { navBackStackEntry ->
            TeamDetailScreen(
                navController = navController,
                teamId = navBackStackEntry.arguments?.getString("teamId")!!
            )
        }
        composable(route = Screen.FavoriteTeamsScreen.route) {
            FavoriteTeamsScreen(navController = navController)
        }
    }
}