package com.analyticahouse.test.presentation.screens.favorite

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.analyticahouse.test.data.local.model.PlayerEntity

@ExperimentalAnimationApi
@Composable
fun FavoritePlayersScreen(
    viewModelDatabase: FavoritePlayersViewModel = hiltViewModel()
) {
    val favoritePlayers = viewModelDatabase.favoritePlayerList.value
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            LazyColumn(
                contentPadding = PaddingValues(10.dp)
            ) {
                items(favoritePlayers) { player ->
                    FavoritePlayersRow(
                        item = player,
                        context = context
                    ) {
                        viewModelDatabase.deleteFavoritePlayer(player)
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                viewModelDatabase.deleteAllFavoritePlayer()
                Toast.makeText(context, "Deleted All Players", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Delete All")
            }
        }
    }
}


@ExperimentalAnimationApi
@Composable
fun FavoritePlayersRow(item: PlayerEntity, context: Context, onClick: () -> Unit) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 10.dp)
    ) {
        Card(
            modifier = Modifier
                .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
                .fillMaxWidth(),
            elevation = 5.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(Modifier.padding(8.dp)) {
                var expanded by remember { mutableStateOf(false) }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 6.dp, end = 6.dp)
                ) {
                    Text(
                        text = item.firstName + " " + item.lastName,
                        fontSize = 20.sp, color = Color.Red
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = item.position, fontSize = 18.sp, color = Color.DarkGray)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 6.dp, end = 6.dp)
                ) {
                    Text(text = "Height Feet: " + item.heightFeet, fontSize = 16.sp)
                    Text(text = "Height Inches: " + item.heightInches, fontSize = 16.sp)
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Arrow",
                        modifier = Modifier.clickable { expanded = !expanded }
                    )
                }

                AnimatedVisibility(visible = expanded) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 6.dp, end = 6.dp)
                    ) {
                        Text(text = item.fullName, color = Color.Gray, fontSize = 16.sp)
                        Text(text = item.city, color = Color.Gray, fontSize = 16.sp)
                        IconButton(onClick = {
                            onClick()
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
                        }) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}