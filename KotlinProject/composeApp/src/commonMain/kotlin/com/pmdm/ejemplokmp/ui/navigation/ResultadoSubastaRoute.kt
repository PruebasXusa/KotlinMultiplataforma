package com.pmdm.agenda.ui.navigation



import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
import org.example.project.features.ResultadoSubasta
import org.example.project.features.ResultadoSubastaScreen


fun EntryProviderScope<NavKey>.restultadoSubastaDestination(
    onBack : () -> Unit,
) {
   entry<ResultadoSubasta> {
        ResultadoSubastaScreen (onBack)
    }
}