package com.analyticahouse.test.presentation.screens.team

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TeamDetailScreen(
    viewModel: TeamDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val team = state.team
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        team?.let {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = it.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.height(25.dp))
                Text(text = "Full Name : ${it.fullName}", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "City : ${it.city}", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Division : ${it.division}", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Conference : ${it.conference}", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Abbreviation : ${it.abbreviation}", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(20.dp))
                IconButton(
                    onClick = {
                        // add this player to the database
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
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
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}