package org.example.project.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider

import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.pmdm.agenda.ui.navigation.restultadoSubastaDestination
import com.pmdm.agenda.ui.navigation.subastaDestination

import com.pmdm.ejemplokmp.ui.features.SubastaViewModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import org.example.project.features.ResultadoSubasta
import org.example.project.features.Subasta
import org.example.project.features.SubastaScreen


@Composable
fun Navigation(viewModel: SubastaViewModel) {

    //Para que funcione en multiplataforma, se registran los tipos (open polymorphic)
    val config = SavedStateConfiguration {
        serializersModule = SerializersModule {
            polymorphic(
                baseClass = NavKey::class,
                actualClass = Subasta::class,
                actualSerializer = Subasta.serializer()
            )
            polymorphic(
                baseClass = NavKey::class,
                actualClass = ResultadoSubasta::class,
                actualSerializer = ResultadoSubasta.serializer()
            )
        }
    }

    val backStack = rememberNavBackStack(configuration = config, elements = arrayOf(Subasta))

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {


            subastaDestination(
                subastaUiState = viewModel.subastaUiState,
                onBack = { },
                onNavigateToNext = {
                   backStack.add(
                        ResultadoSubasta
                    )
                })
            restultadoSubastaDestination({  backStack.removeLastOrNull() })

        })
}

