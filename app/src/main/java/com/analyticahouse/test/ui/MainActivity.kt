package com.analyticahouse.test.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.analyticahouse.test.ui.navigation.BottomBarItem
import com.analyticahouse.test.ui.navigation.Screen
import com.analyticahouse.test.ui.screens.common.AppTopBar
import com.analyticahouse.test.ui.screens.favorite.FavoritePlayersScreen
import com.analyticahouse.test.ui.screens.favorite.FavoriteTeamsScreen
import com.analyticahouse.test.ui.screens.favorite.FavoritesScreen
import com.analyticahouse.test.ui.screens.player.PlayerDetailScreen
import com.analyticahouse.test.ui.screens.player.PlayersScreen
import com.analyticahouse.test.ui.screens.team.TeamDetailScreen
import com.analyticahouse.test.ui.screens.team.TeamsScreen
import com.analyticahouse.test.ui.theme.AnalyticaHouseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnalyticaHouseTheme {
                val navController = rememberNavController()
                MainScreen(navController = navController)
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            AppBottomBar(navController = navController)
        },
        topBar = {
            AppTopBar()
        }
    ) {
        AppNavHost(navController = navController)
    }
}

@Composable
fun AppBottomBar(navController: NavController) {
    BottomNavigation {
        val items = listOf(
            BottomBarItem("Teams", Screen.TeamsScreen.route, Icons.Default.List),
            BottomBarItem("Players", Screen.PlayersScreen.route, Icons.Default.Person),
            BottomBarItem("Favorites", Screen.FavoritesScreen.route, Icons.Default.Favorite)
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(text = screen.name) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.White,
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.TeamsScreen.route) {
        composable(Screen.TeamsScreen.route) { TeamsScreen(navController = navController) }
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
        composable(Screen.PlayersScreen.route) { PlayersScreen(navController = navController) }
        composable(
            route = Screen.PlayerDetailScreen.route + "/{playerId}",
            arguments = listOf(
                navArgument("playerId") {
                    type = NavType.StringType
                    defaultValue = "2"
                }
            )
        ) { navBackStackEntry ->
            PlayerDetailScreen(
                navController = navController,
                playerId = navBackStackEntry.arguments?.getString("playerId")!!
            )
        }
        composable(Screen.FavoritesScreen.route) { FavoritesScreen(navController = navController) }
        composable(Screen.FavoriteTeamsScreen.route) { FavoriteTeamsScreen(navController) }
        composable(Screen.FavoritePlayersScreen.route) { FavoritePlayersScreen(navController = navController) }
    }
}