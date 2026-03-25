package com.pmdm.ejemplokmp.data.mocks

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.american_gothic
import kotlinproject.composeapp.generated.resources.girl_with_pearl
import kotlinproject.composeapp.generated.resources.guernica
import kotlinproject.composeapp.generated.resources.mona_lisa
import kotlinproject.composeapp.generated.resources.starry_night
import kotlinproject.composeapp.generated.resources.the_creation_of_adam
import kotlinproject.composeapp.generated.resources.the_persistence_of_memory
import kotlinproject.composeapp.generated.resources.the_scream
import org.koin.core.annotation.Singleton


@Singleton
class CuadroSubastaDaoMock {

    val cuadros = listOf(
        CuadroSubastaMock("Mona Lisa", "EUR 5000", Res.drawable.mona_lisa),
        CuadroSubastaMock("El Grito", "EUR 4200", Res.drawable.the_scream),
        CuadroSubastaMock("La joven de la perla", "EUR 3900", Res.drawable.girl_with_pearl),
        CuadroSubastaMock("La noche estrellada", "EUR 6100", Res.drawable.starry_night),
        CuadroSubastaMock("La persistencia de la memoria", "EUR 5600", Res.drawable.the_persistence_of_memory),
        CuadroSubastaMock("Guernica", "EUR 6800", Res.drawable.guernica),
        CuadroSubastaMock("El nacimiento de Venus", "EUR 5900", Res.drawable.girl_with_pearl),
        CuadroSubastaMock("Gótico americano", "EUR 4700", Res.drawable.american_gothic),
        CuadroSubastaMock("El beso", "EUR 6400", Res.drawable.mona_lisa),
        CuadroSubastaMock("La creación de Adán", "EUR 7000", Res.drawable.the_creation_of_adam)
    )

    fun get(id: Int): CuadroSubastaMock = cuadros[id]
    fun get(): List<CuadroSubastaMock> = cuadros
}
