package com.pmdm.ejemplokmp.data

import com.pmdm.ejemplokmp.modelo.CuadroSubasta
import org.koin.core.annotation.Singleton

@Singleton
class SubastaRepository(private val cuadroSubastaDaoMock: CuadroSubastaDaoMock) {


    fun get(id: Int): CuadroSubasta {
        return cuadroSubastaDaoMock.get(id).toCuadroSubasta()
    }
    fun get(): List<CuadroSubasta> {
        return cuadroSubastaDaoMock.get().toCuadrosSubasta()
    }
}

