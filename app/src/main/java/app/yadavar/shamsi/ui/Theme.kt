package app.yadavar.shamsi.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AccentOption(val id: String, val label: String, val color: Color)

/** Color themes of the app (the first one is the default). */
val AccentOptions = listOf(
    AccentOption("purple", "بنفش", Color(0xFFB9A7E8)),
    AccentOption("indigo", "نیلی", Color(0xFFAAB8E8)),
    AccentOption("blue", "آبی", Color(0xFF9FC9F2)),
    AccentOption("teal", "سبزآبی", Color(0xFF9EDBD0)),
    AccentOption("green", "سبز", Color(0xFFA8D8B0)),
    AccentOption("amber", "کهربایی", Color(0xFFF1D39B)),
    AccentOption("orange", "نارنجی", Color(0xFFF2C0A0)),
    AccentOption("rose", "صورتی", Color(0xFFF0B5CC)),
    AccentOption("brown", "قهوه‌ای", Color(0xFFD6BDB3)),
    AccentOption("slate", "خاکستری", Color(0xFFB8C8D0)),
)

fun accentColor(name: String): Color =
    AccentOptions.firstOrNull { it.id == name }?.color ?: AccentOptions.first().color

/** Size of the texts inside the app (the widget has its own size setting). */
val AppFontOptions = listOf("sm" to "کوچک", "md" to "متوسط", "lg" to "بزرگ", "xl" to "خیلی بزرگ")

fun appTextScale(id: String): Float = when (id) {
    "sm" -> 0.9f
    "lg" -> 1.15f
    "xl" -> 1.3f
    else -> 1f
}

private val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(12.dp),
    small = RoundedCornerShape(16.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(28.dp),
)

// Slightly larger text with roomier lines, for easier reading.
private val AppTypography = Typography(
    headlineSmall = TextStyle(fontSize = 24.sp, lineHeight = 34.sp, fontWeight = FontWeight.SemiBold),
    titleLarge = TextStyle(fontSize = 21.sp, lineHeight = 30.sp, fontWeight = FontWeight.SemiBold),
    titleMedium = TextStyle(fontSize = 17.sp, lineHeight = 26.sp, fontWeight = FontWeight.Medium),
    titleSmall = TextStyle(fontSize = 15.sp, lineHeight = 23.sp, fontWeight = FontWeight.Medium),
    bodyLarge = TextStyle(fontSize = 16.sp, lineHeight = 26.sp),
    bodyMedium = TextStyle(fontSize = 15.sp, lineHeight = 24.sp),
    bodySmall = TextStyle(fontSize = 13.sp, lineHeight = 21.sp),
    labelLarge = TextStyle(fontSize = 14.sp, lineHeight = 21.sp, fontWeight = FontWeight.Medium),
    labelMedium = TextStyle(fontSize = 12.5.sp, lineHeight = 19.sp, fontWeight = FontWeight.Medium),
)

@Composable
fun YadavarTheme(theme: String, accent: String, textScale: Float = 1f, content: @Composable () -> Unit) {
    val dark = when (theme) {
        "light" -> false
        "dark" -> true
        else -> isSystemInDarkTheme()
    }
    val primary = accentColor(accent)
    val scheme = if (dark) {
        // Selected chips and the main buttons share the accent hue.
        val tint = lerp(Color(0xFF181B22), primary, 0.40f)
        darkColorScheme(
            primary = primary,
            primaryContainer = tint,
            secondaryContainer = tint,
            onSecondaryContainer = Color.White,
            background = Color(0xFF101114),
            surface = Color(0xFF181B22),
            surfaceContainer = Color(0xFF22262F),
        )
    } else {
        val tint = lerp(Color.White, primary, 0.16f)
        lightColorScheme(
            primary = primary,
            primaryContainer = tint,
            secondaryContainer = tint,
            onSecondaryContainer = lerp(primary, Color.Black, 0.35f),
            background = lerp(Color(0xFFFFFBFF), primary, 0.075f),
            surface = Color(0xFFFFFFFF),
            surfaceContainer = Color(0xFFEEF1F4),
        )
    }
    val base = LocalDensity.current
    CompositionLocalProvider(LocalDensity provides Density(base.density, base.fontScale * textScale)) {
        MaterialTheme(colorScheme = scheme, shapes = AppShapes, typography = AppTypography, content = content)
    }
}
