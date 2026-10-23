package org.insbaixcamp.appfitnessa.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import org.insbaixcamp.appfitnessa.R
import org.insbaixcamp.appfitnessa.ui.components.CalendariPicker
import org.insbaixcamp.appfitnessa.ui.components.MenuDesplegable

@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    alçada: Int,
    pes: Double,
    pesObjectiu : Double,
    objectiu: String,
    nivellActivitat: String,
    guardar: (String, String, String, String, Int, Double, Double, String, String) -> Unit
) {
    var nomNou: String by remember { mutableStateOf(nom) }
    var emailNou: String by remember { mutableStateOf(email) }
    var dataNaixementNou: String by remember { mutableStateOf(dataNaixement) }
    var genereNou: String by remember { mutableStateOf(genere) }
    var alçadaNou: Int by remember { mutableStateOf(alçada) }
    var pesNou: Double by remember { mutableStateOf(pes) }
    var pesObjectiuNou: Double by remember { mutableStateOf(pesObjectiu) }
    var objectiuNou:String by remember { mutableStateOf(objectiu) }
    var nivellActivitatNou:String by remember { mutableStateOf(nivellActivitat) }

    var opcionsGenere = listOf("Masculí", "Femení", "Prefereixo no dir-ho")
    var opcionsObjectiu = listOf("Guanyar massa muscular", "Redueix pes", "Manté el meu pes")

    Column() {
        Row(Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                Modifier.padding(start = 24.dp)
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Black),
            )
            Column(Modifier.fillMaxWidth().padding(end = 8.dp),
                horizontalAlignment = Alignment.End) {
                Button(onClick = {}) { Text(text = "Canviar foto") }
                Button(onClick = {}) { Text(text = "Eliminar foto") }
            }
        }
        Text(text = "Dades personals",
            modifier = Modifier.padding(top = 16.dp, start = 8.dp))
        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom complet") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )
        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )
        //Data naixement
        CalendariPicker(
            label = "Data de naixement",
            selectedDateMillis = dataNaixementNou.toLongOrNull(),
            onDateSelected = { dataNaixementNou = it.toString() },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )
        //Genere
        MenuDesplegable(
            label = "Genere",
            opcions = opcionsGenere,
            valorSeleccionat = genereNou,
            onValorSeleccionat = { genereNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )

        //Dades físiques
        Text(text = "Dades físiques",
            modifier = Modifier.padding(top = 16.dp, start = 8.dp))
        Row(modifier = Modifier.fillMaxWidth()){
            OutlinedTextField(
                value = alçadaNou.toString(),
                onValueChange = { alçadaNou = it.toIntOrNull() ?: 0 },
                label = { Text("Alçada (cm)") },
                modifier = Modifier.weight(1f).padding(start = 8.dp, end = 4.dp),

            )
            OutlinedTextField(
                value = pesNou.toString(),
                onValueChange = { pesNou = it.toDoubleOrNull() ?: 0.0 },
                label = { Text("Pes (kg)") },
                modifier = Modifier.weight(1f).padding(start = 4.dp, end = 4.dp),
                )
            OutlinedTextField(
                value = pesObjectiuNou.toString(),
                onValueChange = { pesObjectiuNou = it.toDoubleOrNull() ?: 0.0 },
                label = { Text("Pes (kg)") },
                modifier = Modifier.weight(1f).padding(start = 4.dp, end = 8.dp),

                )
        }
        Text(text = "Objectiu Principal",
            modifier = Modifier.padding(top = 16.dp, start = 8.dp))
        MenuDesplegable(
            label = "",
            opcions = opcionsObjectiu,
            valorSeleccionat = objectiuNou,
            onValorSeleccionat = { objectiuNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )
        Button(onClick = { guardar(nomNou,emailNou,dataNaixementNou,genereNou,alçadaNou,pesNou,pesObjectiuNou,objectiuNou,nivellActivitatNou) }) {
            Text("Guardar dades")
        }

    }
}
