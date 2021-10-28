package com.analyticahouse.test.ui.screens.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppTopBar() {
    TopAppBar(
        title = { Text("AnalyticaHouse") }
    )
}