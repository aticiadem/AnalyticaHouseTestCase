package com.analyticahouse.test.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.analyticahouse.test.presentation.navigation.BottomBarItem
import com.analyticahouse.test.presentation.navigation.Screen
import com.analyticahouse.test.presentation.screens.common.AppTopBar
import com.analyticahouse.test.presentation.screens.favorite.FavoritePlayersScreen
import com.analyticahouse.test.presentation.screens.favorite.FavoriteTeamsScreen
import com.analyticahouse.test.presentation.screens.favorite.FavoritesScreen
import com.analyticahouse.test.presentation.screens.player.PlayerDetailScreen
import com.analyticahouse.test.presentation.screens.player.PlayersScreen
import com.analyticahouse.test.presentation.screens.team.TeamDetailScreen
import com.analyticahouse.test.presentation.screens.team.TeamsScreen
import com.analyticahouse.test.presentation.ui.theme.AnalyticaHouseTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnalyticaHouseTheme {
                val navController = rememberNavController()
                val currentScreen = rememberSaveable { (mutableStateOf(Screen.TeamsScreen.route)) }

                MainScreen(navController = navController, currentScreen = currentScreen)
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MainScreen(
    navController: NavHostController,
    currentScreen: MutableState<String>,
) {
    Scaffold(
        bottomBar = {
            AppBottomBar(navController = navController, currentScreen = currentScreen)
        },
        topBar = {
            AppTopBar()
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            AppNavHost(
                navController = navController,
                currentScreen = currentScreen
            )
        }
    }
}

@Composable
fun AppBottomBar(
    navController: NavHostController,
    currentScreen: MutableState<String>,
) {
    BottomNavigation {
        val items = listOf(
            BottomBarItem("Teams", Screen.TeamsScreen.route, Icons.Default.List),
            BottomBarItem("Players", Screen.PlayersScreen.route, Icons.Default.Person),
            BottomBarItem("Favorites", Screen.FavoritesScreen.route, Icons.Default.Favorite)
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        BottomNavigation {
            items.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController,
                    currentScreen = currentScreen
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun AppNavHost(
    navController: NavHostController,
    currentScreen: MutableState<String>,
) {
    NavHost(navController = navController, startDestination = Screen.TeamsScreen.route) {
        composable(Screen.TeamsScreen.route) {
            TeamsScreen(
                navController = navController,
                currentScreen = currentScreen
            )
        }
        composable(route = Screen.TeamDetailScreen.route + "/{teamId}") {
            TeamDetailScreen(currentScreen = currentScreen)
        }
        composable(Screen.PlayersScreen.route) {
            PlayersScreen(
                navController = navController,
                currentScreen = currentScreen
            )
        }
        composable(route = Screen.PlayerDetailScreen.route + "/{playerId}") {
            PlayerDetailScreen()
        }
        composable(Screen.FavoritesScreen.route) {
            FavoritesScreen(
                navController = navController,
                currentScreen = currentScreen
            )
        }
        composable(Screen.FavoriteTeamsScreen.route) {
            FavoriteTeamsScreen()
        }
        composable(Screen.FavoritePlayersScreen.route) {
            FavoritePlayersScreen()
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarItem,
    currentDestination: NavDestination?,
    navController: NavHostController,
    currentScreen: MutableState<String>,
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.name)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = null)
        },
        selected = currentDestination?.hierarchy?.any {
            currentScreen.value == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        selectedContentColor = Color.White,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}