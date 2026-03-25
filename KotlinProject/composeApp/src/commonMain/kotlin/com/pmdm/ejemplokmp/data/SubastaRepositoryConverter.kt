package com.pmdm.ejemplokmp.data

import com.pmdm.ejemplokmp.data.mocks.CuadroSubastaMock
import com.pmdm.ejemplokmp.modelo.CuadroSubasta


    fun CuadroSubastaMock.toCuadroSubasta(): CuadroSubasta = CuadroSubasta(
        titulo = titulo,
        precioInicial = precioInicial,
        imagen = imagen
    )
    fun CuadroSubasta.toCuadroSubastaMock(): CuadroSubastaMock = CuadroSubastaMock(
        titulo = titulo,
        precioInicial = precioInicial,
        imagen = imagen
    )
    fun List<CuadroSubasta>.toCuadrosSubastaMock()= map { it.toCuadroSubastaMock() }
    fun List<CuadroSubastaMock>.toCuadrosSubasta()= map { it.toCuadroSubasta() }







