package com.raiseralex.challengekosmos

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.raiseralex.challengekosmos.data.models.Character
import com.raiseralex.challengekosmos.data.models.Location
import com.raiseralex.challengekosmos.data.models.Origin
import com.raiseralex.challengekosmos.presentation.ui.screens.CharacterItem
import com.raiseralex.challengekosmos.presentation.ui.theme.ChallengeKosmosTheme
import org.junit.Rule
import org.junit.Test

class UiHomeComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun CharacterItemIsExpand() {
        composeTestRule.setContent {
            ChallengeKosmosTheme {
                CharacterItem(character = dummyCharacter)
            }
        }
        // PRINT ROOT_

        for (click in 0 .. 10) {
            // SHOW -> VER DETALLE
            composeTestRule.onNodeWithText("Ver detalle").assertIsDisplayed()
            composeTestRule.onNode(hasText("Ver detalle")).performClick()
            // SHOW -> OCULTAR DETALLE
            composeTestRule.onNodeWithText("Ocultar detalle").assertIsDisplayed()
            composeTestRule.onNode(hasText("Ocultar detalle")).performClick()
        }

        composeTestRule.onRoot().printToLog("ITEM")


    }

    @Test
    fun InsertDataIntoCharacterItemCompose() {
        composeTestRule.setContent {
            ChallengeKosmosTheme {
                CharacterItem(character = dummyCharacter)
            }
        }


        composeTestRule.onNodeWithText(dummyCharacter.name).assertIsDisplayed()

        composeTestRule.onNodeWithText("Ver detalle").assertIsDisplayed()
        composeTestRule.onNode(hasText("Ver detalle")).performClick()

        composeTestRule.onNodeWithText("Ocultar detalle").assertIsDisplayed()
        composeTestRule.onNodeWithText(dummyCharacter.status).assertIsDisplayed()
        composeTestRule.onNodeWithText(dummyCharacter.species).assertIsDisplayed()

        composeTestRule.onNodeWithText(if (dummyCharacter.type.isEmpty()) "Unknown" else dummyCharacter.type).assertIsDisplayed()
        composeTestRule.onNodeWithText(dummyCharacter.gender).assertIsDisplayed()

        composeTestRule.onNodeWithText(dummyCharacter.origin.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(dummyCharacter.location.name).assertIsDisplayed()

        composeTestRule.onRoot().printToLog("ITEM")
    }

    val dummyCharacter = Character(
        id = 1,
        name = "Rick Sanchez",
        status = "Alive",
        species = "Human",
        type = "", // Optional value
        gender = "Male",
        origin = Origin(
            name = "Earth (Dimension C-137)",
            url = "https://rickandmortyapi.com/api/location/1"
        ),
        location = Location(
            name = "Citadel of Ricks",
            url = "https://rickandmortyapi.com/api/location/3"
        ),
        image = "https://i.imgur.com/pRJ0hDW.png",
        episode = listOf(
            "https://rickandmortyapi.com/api/episode/1",
            "https://rickandmortyapi.com/api/episode/2",
            // ... add more episodes as needed
        ),
        url = "https://rickandmortyapi.com/api/character/1",
        created = "2017-11-04T18:50:21.437Z"
    )
}