package com.raiseralex.challengekosmos.presentation.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.raiseralex.challengekosmos.KosmosApplication
import com.raiseralex.challengekosmos.data.models.Character
import com.raiseralex.challengekosmos.domain.repositories.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(
    application: Application,
    private val repository: RickAndMortyRepository
): AndroidViewModel(application) {

    //  Este bloque de inicialización se ejecuta cuando se crea una instancia del ViewModel.
    init {
        // Este bloque de inicialización se ejecuta cuando se crea una instancia del ViewModel.
        // Dentro de este bloque, se inicia un viewModelScope con un lanzamiento en un
        // hilo de Entrda/Salida (dispatcherIO de la clase KosmosApplication).
        viewModelScope.launch(KosmosApplication.dispatcherIO) {
            val character = getCharacters()
            _characterState.value = character
        }
    }

    private val _characterState = MutableStateFlow<List<Character>>(emptyList())
    val characterState: StateFlow<List<Character>> = _characterState.asStateFlow()
    private suspend fun getCharacters(): List<Character> {
        return repository.getCharacters().results
    }
}