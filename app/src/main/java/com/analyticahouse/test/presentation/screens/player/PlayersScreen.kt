package com.analyticahouse.test.presentation.screens.player

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.analyticahouse.test.domain.model.player.Player
import com.analyticahouse.test.presentation.navigation.Screen
import com.analyticahouse.test.presentation.ui.theme.Purple500

@ExperimentalMaterialApi
@Composable
fun PlayersScreen(
    navController: NavController,
    viewModel: PlayersViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.players) { player ->
                PlayerCard(player) {
                    navController.navigate(Screen.PlayerDetailScreen.withArgs(player.id.toString()))
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
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(48.dp)
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun PlayerCard(
    item: Player,
    onItemClick: (Player) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .border(
                    1.dp,
                    Purple500,
                    RoundedCornerShape(15.dp)
                ),
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            onClick = { onItemClick(item) }
        ) {
            Column(
                modifier = Modifier.padding(
                    start = 15.dp,
                    top = 10.dp,
                    bottom = 10.dp,
                    end = 10.dp
                ),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "${item.firstName} ${item.lastName}", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Position: ${item.position}", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Team: ${item.team.name}", fontSize = 18.sp)
            }
        }
    }
}