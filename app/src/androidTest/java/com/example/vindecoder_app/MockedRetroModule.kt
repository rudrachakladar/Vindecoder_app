package com.example.vindecoder_app



import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import org.mockito.kotlin.mock
import javax.inject.Singleton

/**
 * Created by Shubham Singh on 19/04/23.
 */
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RetroModule::class]
)
object MockedRetroModule {

    @Provides
    @Singleton
    fun provideApiService(): Vehicleapi = mock()
}