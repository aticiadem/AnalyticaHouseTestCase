package com.analyticahouse.test.ui.navigation

sealed class Screen(val route: String) {

    object TeamsScreen : Screen("teamsScreen")
    object TeamDetailScreen : Screen("teamDetailScreen")
    object PlayersScreen : Screen("playersScreen")
    object PlayerDetailScreen : Screen("playerDetailScreen")
    object FavoriteTeamsScreen : Screen("favoriteTeamsScreen")
    object FavoritePlayersScreen : Screen("favoritePlayersScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
