package com.raiseralex.challengekosmos

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers

// clase KosmosApplication proporciona una estructura para la configuración y la inicialización de la aplicación,
// incluyendo la definición de constantes para los despachadores de hilos y la URL base de una API.
@HiltAndroidApp
class KosmosApplication: Application() {

    companion object {
        val dispatcherIO = Dispatchers.IO
        val dispatcherMain = Dispatchers.Main

        val baseUrl = "https://rickandmortyapi.com/api/"
    }
}