package com.pmdm.agenda.ui.navigation


import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.pmdm.ejemplokmp.ui.features.SubastaUiState
import org.example.project.features.Subasta
import org.example.project.features.SubastaScreen

fun EntryProviderScope<NavKey>.subastaDestination(
    subastaUiState: SubastaUiState,
    onBack : () -> Unit, onNavigateToNext : () -> Unit
) {
    entry<Subasta> {
        SubastaScreen (subastaUiState, onBack, onNavigateToNext)
    }
}