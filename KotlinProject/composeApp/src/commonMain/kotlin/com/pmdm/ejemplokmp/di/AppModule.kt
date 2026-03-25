package com.pmdm.ejemplokmp.di

import com.pmdm.ejemplokmp.data.mocks.CuadroSubastaDaoMock
import com.pmdm.ejemplokmp.data.SubastaRepository
import com.pmdm.ejemplokmp.ui.features.SubastaViewModel
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton


@KoinApplication
object KoinApp


@Module
class AppModule {

    @Singleton
    fun subastaRepository(): SubastaRepository {
        return SubastaRepository(CuadroSubastaDaoMock())
    }

    @Singleton
    fun subastaViewModel(): SubastaViewModel {
        return SubastaViewModel(subastaRepository())
    }
}