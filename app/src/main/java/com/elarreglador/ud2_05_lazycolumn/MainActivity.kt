package com.elarreglador.ud2_05_lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elarreglador.ud2_05_lazycolumn.ui.theme.UD2_05_LazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UD2_05_LazyColumnTheme{
                DynamicLazyColumn()
            }
        }
    }
}

@Composable
fun DynamicLazyColumn() {
    // Estado de la lista para almacenar los elementos
    // contiene true/false y un String con el texto de cada check
    val listado = remember { mutableStateListOf<Pair<Boolean, String>>() }

    Column {
        Button(
            onClick = {
                listado.add( Pair ( false, "check ${listado.size + 1} : " ) )
            },
        ) {
            Text("Agregar")
        }

        LazyColumn {
            // Recorre listado y agrega un Row { checkbox + text } para cada item
            // item es la pareja Pair<Boolean, String>
            items(listado) { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Checkbox(
                        // item.first se refiere al valor booleano
                        checked = item.first,
                        onCheckedChange = { isChecked ->
                            // Buscar la posición del item actual dentro del listado
                            val posicion = listado.indexOf(item)
                            if (posicion != -1) {
                                // Actualiza el item en la posición encontrada, copiando el estado cambiado
                                listado[posicion] = item.copy(first = isChecked)
                            }
                        }
                    )
                    // Texto del check mostrando el String y el valor boolean de listado
                    Text(item.second + " " + item.first)
                }
            }
        }
    }
}
