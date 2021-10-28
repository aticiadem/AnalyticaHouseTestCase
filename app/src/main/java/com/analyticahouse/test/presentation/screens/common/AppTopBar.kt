package com.analyticahouse.test.presentation.screens.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun AppTopBar() {
    TopAppBar(
        title = { Text("AnalyticaHouse") }
    )
}