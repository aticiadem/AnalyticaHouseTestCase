package com.analyticahouse.test.presentation.screens.favorite

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.analyticahouse.test.domain.model.team.Team

@Composable
fun FavoriteTeamsScreen(
    viewModel: FavoriteTeamsViewModel = hiltViewModel()
) {
    val favoriteTeams = viewModel.favoriteTeamList.value
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                items(favoriteTeams) { team ->
                    FavoriteTeamsRow(
                        item = team,
                        context = context
                    ) {
                        viewModel.deleteFavoriteTeam(team)
                    }
                }
            }
            Button(onClick = {
                viewModel.deleteAllFavoriteTeam()
                Toast.makeText(context, "Deleted all item", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Delete All")
            }
        }
    }
}

@Composable
fun FavoriteTeamsRow(item: Team, context: Context, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = item.name,
            modifier = Modifier.width(110.dp),
            fontSize = 16.sp,
            color = Color.Red
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = item.city, modifier = Modifier.width(130.dp), fontSize = 16.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = item.abbreviation, modifier = Modifier.width(65.dp), fontSize = 16.sp)
        IconButton(onClick = {
            onClick()
            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
        }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
        }
    }
}