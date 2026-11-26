package com.example.profil

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.example.profil.data.thomasProfile
import com.example.profil.ui.ProfileScreen
import com.example.profil.ui.theme.ProfilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val layoutDirection = LocalLayoutDirection.current
                    ProfileScreen(
                        profile = thomasProfile,
                        onContactClick = { envoyerEmail(thomasProfile.email) },
                        // Pas de vrai téléchargement : action simulée
                        onDownloadCvClick = {
                            Toast.makeText(this, "CV bientôt disponible", Toast.LENGTH_SHORT).show()
                        },
                        contentPadding = PaddingValues(
                            start = innerPadding.calculateStartPadding(layoutDirection) + 16.dp,
                            top = innerPadding.calculateTopPadding() + 16.dp,
                            end = innerPadding.calculateEndPadding(layoutDirection) + 16.dp,
                            bottom = innerPadding.calculateBottomPadding() + 16.dp
                        )
                    )
                }
            }
        }
    }

    private fun envoyerEmail(adresse: String) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$adresse"))
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Aucune application e-mail installée", Toast.LENGTH_SHORT).show()
        }
    }
}
