package com.analyticahouse.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.analyticahouse.test.ui.navigation.BottomNavItem
import com.analyticahouse.test.ui.navigation.BottomScreen
import com.analyticahouse.test.ui.navigation.Screen
import com.analyticahouse.test.ui.screens.player.PlayersScreen
import com.analyticahouse.test.ui.screens.team.TeamsScreen
import com.analyticahouse.test.ui.theme.AnalyticaHouseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnalyticaHouseTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigatorBar(
                items = listOf(
                    BottomNavItem(
                        name = "Teams",
                        route = Screen.TeamsScreen.route,
                        icon = Icons.Default.Menu
                    ),
                    BottomNavItem(
                        name = "Players",
                        route = Screen.PlayersScreen.route,
                        icon = Icons.Default.Person
                    )
                ),
                navController = navController
            )
        }
    ) {
        NavHost(
            navController,
            startDestination = BottomScreen.TeamsScreen.route
        ) {
            composable(BottomScreen.TeamsScreen.route) { TeamsScreen() }
            composable(BottomScreen.PlayersScreen.route) { PlayersScreen() }
        }
    }
}

/*@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.TeamsScreen.route) {
        composable(route = Screen.TeamsScreen.route) {
            TeamsScreen(navController = navController)
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
        composable(route = Screen.PlayersScreen.route) {
            PlayersScreen(navController = navController)
        }
        composable(
            route = Screen.PlayerDetailScreen.route + "/{playerId}"
        ) { navBackStackEntry ->
            PlayerDetailScreen(
                navController = navController,
                playerId = navBackStackEntry.arguments?.getString("playerId")!!
            )
        }
        composable(route = Screen.FavoriteTeamsScreen.route) {
            FavoriteTeamsScreen(navController = navController)
        }
        composable(route = Screen.FavoritePlayersScreen.route) {
            FavoritePlayersScreen(navController = navController)
        }
    }
}*/

@Composable
fun BottomNavigatorBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Gray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            BottomNavigationItem(
                selected = selected,
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.White,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = false
                    }
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null
                        )
                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}