package com.pmdm.ejemplokmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.pmdm.ejemplokmp.di.KoinApp
import com.pmdm.ejemplokmp.ui.features.SubastaViewModel
import org.example.project.ui.navigation.Navigation
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel
import org.koin.plugin.module.dsl.koinConfiguration


@Composable
@Preview
fun App() {
    KoinApplication(configuration = koinConfiguration<KoinApp>()) {
        MaterialTheme {
            val subastaViewModel: SubastaViewModel = koinViewModel()
            Surface {
                Navigation(subastaViewModel)
            }
        }
    }
}