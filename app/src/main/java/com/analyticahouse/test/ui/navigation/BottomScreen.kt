package com.analyticahouse.test.ui.navigation

sealed class BottomScreen {

    object TeamsScreen : Screen("teamsScreen")
    object PlayersScreen : Screen("playersScreen")

}