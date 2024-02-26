package com.raiseralex.challengekosmos.di

import com.raiseralex.challengekosmos.KosmosApplication
import com.raiseralex.challengekosmos.data.remote.RickAndMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Define un objeto singleton llamado NetworkModule,
// que contendrá los métodos de proveedor de dependencias.
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Este método provee una instancia de Retrofit, que es un cliente HTTP para Android
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(KosmosApplication.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //  Este método provee una instancia de la interfaz RickAndMortyApi, que se utilizará para realizar llamadas a la API de Rick and Morty.
    //  Está anotado con @Singleton, lo que garantiza que Dagger/Hilt proporcionará una única instancia de RickAndMortyApi para toda la
    //  aplicación.
    @Singleton
    @Provides
    fun providesApi(retrofit: Retrofit): RickAndMortyApi {
        return retrofit.create(RickAndMortyApi::class.java)
    }
}