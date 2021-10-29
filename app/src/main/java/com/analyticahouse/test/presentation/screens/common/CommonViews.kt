package com.analyticahouse.test.presentation.screens.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.analyticahouse.test.domain.model.team.Team
import com.analyticahouse.test.presentation.navigation.Screen
import com.analyticahouse.test.presentation.ui.theme.Purple500

@ExperimentalMaterialApi
@Composable
fun TeamCard(
    item: Team,
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .height(150.dp)
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
            onClick = { navController.navigate(Screen.TeamDetailScreen.withArgs(item.id.toString())) }
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
                Text(text = "Name : ${item.name}", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Full Name : ${item.fullName}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "City : ${item.city}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Division : ${item.division}", fontSize = 16.sp)
            }
        }
    }
}