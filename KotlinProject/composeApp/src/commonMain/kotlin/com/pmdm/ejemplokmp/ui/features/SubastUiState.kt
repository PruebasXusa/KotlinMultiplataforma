package com.pmdm.ejemplokmp.ui.features

import com.pmdm.ejemplokmp.modelo.CuadroSubasta
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform

data class SubastaUiState(
    val cuadrosSubasta: List<CuadroSubasta> = emptyList(),
    val puja: String=""
)

