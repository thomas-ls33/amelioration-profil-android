package com.example.profil.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Indigo40,
    onPrimary = Color.White,
    primaryContainer = IndigoContainer90,
    onPrimaryContainer = OnIndigoContainer10,
    secondary = Teal40,
    onSecondary = Color.White,
    secondaryContainer = TealContainer90,
    onSecondaryContainer = OnTealContainer10,
    tertiary = Amber40,
    onTertiary = Color.White,
    tertiaryContainer = AmberContainer90,
    onTertiaryContainer = OnAmberContainer10,
    background = Neutral99,
    onBackground = Neutral10,
    surface = Neutral99,
    onSurface = Neutral10,
    surfaceVariant = NeutralVariant90,
    onSurfaceVariant = NeutralVariant30,
    outline = Outline50
)

private val DarkColorScheme = darkColorScheme(
    primary = Indigo80,
    onPrimary = OnIndigoContainer10,
    primaryContainer = IndigoContainer30,
    onPrimaryContainer = IndigoContainer90,
    secondary = Teal80,
    onSecondary = OnTealContainer10,
    secondaryContainer = TealContainer30,
    onSecondaryContainer = TealContainer90,
    tertiary = Amber80,
    onTertiary = OnAmberContainer10,
    tertiaryContainer = AmberContainer30,
    onTertiaryContainer = AmberContainer90,
    background = Neutral6,
    onBackground = Neutral90,
    surface = Neutral6,
    onSurface = Neutral90,
    surfaceVariant = NeutralVariant20,
    onSurfaceVariant = NeutralVariant80,
    outline = Outline60
)

@Composable
fun ProfilTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Désactivé par défaut pour garder l'identité visuelle de l'application
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
