package com.pmdm.ejemplokmp.ui.features

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.ejemplokmp.data.SubastaRepository
import com.pmdm.ejemplokmp.modelo.CuadroSubasta

class SubastaViewModel : ViewModel() {
        var subastaUiState by mutableStateOf(SubastaUiState())
        val subastaRepository = SubastaRepository()
        init {
            subastaUiState = subastaUiState.copy(subastaRepository.get())
        }



}

