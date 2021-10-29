package com.analyticahouse.test.presentation.screens.team

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.analyticahouse.test.presentation.screens.common.TeamCard

@ExperimentalMaterialApi
@Composable
fun TeamsScreen(
    navController: NavController,
    viewModel: TeamsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.teams) { team ->
                TeamCard(item = team, navController = navController)
            }
        }
    }
    if (state.error.isNotBlank()) {
        Text(
            text = state.error,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
    if (state.isLoading) {
        CircularProgressIndicator(modifier = Modifier.size(48.dp))
    }
}
