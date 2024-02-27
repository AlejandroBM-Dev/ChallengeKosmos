package com.raiseralex.challengekosmos.presentation.ui.screens

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.raiseralex.challengekosmos.data.models.Character
import com.raiseralex.challengekosmos.presentation.ui.viewmodel.HomeViewModel

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenCompose()
}
@Composable
fun HomeScreenCompose() {
    val viewModel: HomeViewModel = hiltViewModel()

    val characters by viewModel.characterState.collectAsState(initial = emptyList())

    Column {
        Text(
            text = "CHALLENGE KOSMOS\nRICK AND MORTY",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )

        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(characters){ character ->
                CharacterItem(
                    character = character
                )
            }
        }
    }
}

// isExpanded... proporciona la validación para mostrar details
@Composable
fun CharacterItem(
    character: Character
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(),
        modifier =
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
            .animateContentSize(),
    )  {
        Row {
            AsyncImage(
                model =
                ImageRequest.Builder(LocalContext.current)
                    .data(character.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier =
                Modifier
                    .size(88.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically),
            )

            Column(
                modifier =
                Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = character.name)
                Button(
                    onClick = {
                        isExpanded = !isExpanded
                    }
                ) {
                    Text(text = if (isExpanded) "Ocultar detalle" else "Ver detalle")
                }
            }
        }

        if(isExpanded) {
            CardDetail(character = character)
        }
    }
}

// Se agrega el compose CardDetail
// STATUS, SPECIES, TYPE, GENDER, NAME, LOCATION NAME
@Composable
fun CardDetail(
    character: Character
) {
    Row {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "STATUS:",
                fontSize = 16.sp
            )
            Text(
                text = character.status,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "SPECIES:",
                fontSize = 15.sp
            )
            Text(
                text = character.species,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "TYPE:",
                fontSize = 15.sp
            )
            Text(text = if (character.type.isEmpty()) "Unknown" else character.type,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "GENDER:",
                fontSize = 15.sp
            )
            Text(text = if (character.gender.isEmpty()) "Unknown" else character.gender,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "NAME:",
                fontSize = 15.sp
            )
            Text(
                text = character.origin.name,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "LOCATION NAME:",
                fontSize = 15.sp
            )
            Text(
                text = character.location.name,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}