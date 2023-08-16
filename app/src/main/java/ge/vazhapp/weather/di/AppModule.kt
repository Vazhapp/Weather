package ge.vazhapp.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ge.vazhapp.weather.data.remote.network.services.CurrentWeatherService
import ge.vazhapp.weather.data.remote.repositories.CurrentWeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Repositories \/
    @Provides
    @Singleton
    fun provideCurrentWeatherRepository(currentWeatherService: CurrentWeatherService): CurrentWeatherRepository =
        CurrentWeatherRepository(currentWeatherService)
}