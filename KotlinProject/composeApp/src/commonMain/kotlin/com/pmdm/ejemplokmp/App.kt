package com.pmdm.ejemplokmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.pmdm.ejemplokmp.ui.features.SubastaViewModel
import org.example.project.ui.navigation.Navigation


@Composable
@Preview
fun App() {
    MaterialTheme {
        val subastaViewModel = remember { SubastaViewModel() }
      Surface {
          Navigation(subastaViewModel)
      }
    }
}