package org.insbaixcamp.appfitnessa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.appfitnessa.ui.screen.EditProfileScreen
import org.insbaixcamp.appfitnessa.ui.screen.ProfileScreen
import org.insbaixcamp.appfitnessa.ui.theme.AppFitnessATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFitnessATheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        FitnessApp()
                    }
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    var nom: String by remember { mutableStateOf("Laia Soler") }
    var email: String by remember { mutableStateOf("laia.soler@exemple.com") }
    //dataNaixement datamillis

    var dataNaixement: Long by remember { mutableStateOf(915148800000L) }
    var genere: String by remember { mutableStateOf("Dona") }
    var alçada: Int by remember { mutableStateOf(170) }
    var pes: Double by remember { mutableStateOf(60.0) }
    var pesObjectiu: Double by remember { mutableStateOf(60.0) }
    var objectiu: String by remember { mutableStateOf("Guanyar massa muscular") }
    var nivellActivitat: String by remember { mutableStateOf("Moderat") }
    var editant: Boolean by remember { mutableStateOf(false) }

    if (editant) {
        EditProfileScreen(
            nom,
            email,
            dataNaixement,
            genere,
            alçada,
            pes,
            pesObjectiu,
            objectiu,
            nivellActivitat,
            { nomN, emailN, dataNaixementN, genereN, alçadaN, pesN, pesObjectiuN, objectiuN, nivellActivitatN ->
                nom = nomN
                email = emailN
                dataNaixement = dataNaixementN
                genere = genereN
                alçada = alçadaN
                pes = pesN
                pesObjectiu = pesObjectiuN
                objectiu = objectiuN
                nivellActivitat = nivellActivitatN
                editant = false
            })
    } else {
        ProfileScreen(
            nom, email, dataNaixement, genere, alçada,
            pes, objectiu, nivellActivitat,
            { editant = true })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppFitnessATheme {
        FitnessApp()
    }
}