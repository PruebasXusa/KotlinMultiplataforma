package org.example.project.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.pmdm.ejemplokmp.ui.features.SubastaUiState
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.girl_with_pearl
import kotlinproject.composeapp.generated.resources.mona_lisa
import kotlinproject.composeapp.generated.resources.the_scream
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private data class CuadroSubasta(
    val titulo: String,
    val precioInicial: String,
    val imagen: DrawableResource
)


@Serializable
data object Subasta: NavKey
{

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubastaScreen(
    subastaUiState: SubastaUiState,
    onBack: () -> Unit = {},
    onNavigateToNext: () -> Unit = {}
) {


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Subastas") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var textState by remember { mutableStateOf("") }

            Text(
                text = "Simulador de Puja",
                style = MaterialTheme.typography.headlineMedium,
            )
            Spacer(modifier = Modifier.height(18.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                val cuadros = subastaUiState.cuadrosSubasta
                items(cuadros) { cuadro ->
                    Card()
                    {
                        Column(modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(cuadro.imagen),
                                contentDescription = cuadro.titulo,
                                modifier = Modifier.size(300.dp),
                                contentScale = ContentScale.Inside,

                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(cuadro.titulo, style = MaterialTheme.typography.titleMedium)
                            Text(
                                text = "Puja inicial: ${cuadro.precioInicial}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            OutlinedTextField(
                value = textState,
                onValueChange = { textState = it },
                placeholder = { Text("añade tu puja") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.68f)
                    .padding(bottom = 12.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = onNavigateToNext,
                modifier = Modifier
                    .fillMaxWidth(0.68f)
                    .height(46.dp)
            ) {
                Text("Aceptar puja")
            }
        }
    }
}
