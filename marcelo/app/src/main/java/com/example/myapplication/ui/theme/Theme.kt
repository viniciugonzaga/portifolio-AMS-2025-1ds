package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
// 1. IMPORT NECESSÁRIO para usar Color.White e Color.Black
import androidx.compose.ui.graphics.Color
// 2. IMPORT NECESSÁRIO para usar PrimaryColor, GradientStart, etc.
import com.example.myapplication.ui.theme.* private val LightColors = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = Color.White,
    primaryContainer = PrimaryLight,
    onPrimaryContainer = PrimaryDark,
    secondary = AccentColor,
    onSecondary = Color.Black, // ✅ Funciona graças ao import androidx.compose.ui.graphics.Color
    secondaryContainer = AccentColor.copy(alpha = 0.2f),
    onSecondaryContainer = PrimaryColor,
    tertiary = GradientStart, // ✅ Funciona graças ao import com.example.myapplication.ui.theme.*
    onTertiary = TextColorPrimary,
    background = BackgroundLight,
    onBackground = TextColorPrimary,
    surface = SurfaceColor,
    onSurface = TextColorPrimary,
    error = ErrorColor,
    onError = Color.White,
    surfaceVariant = GradientEnd // ✅ Funciona graças ao import com.example.myapplication.ui.theme.*
)

@Composable
fun MyApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography, // De Type.kt
        content = content
    )
}