package app.yadavar.shamsi.widget

import androidx.compose.ui.graphics.Color

/** Colors used by the home-screen widget for one background choice. */
data class WidgetPalette(
    val bg: Color,
    val text: Color,
    val muted: Color,
    val accent: Color,
    val line: Color,
    val selected: Color,
    val dark: Boolean,
)

data class WidgetBgOption(val id: String, val label: String, val swatch: Color)

val WidgetBackgrounds = listOf(
    WidgetBgOption("lavender", "بنفش روشن", Color(0xFFF7F3FB)),
    WidgetBgOption("white", "سفید", Color(0xFFFFFFFF)),
    WidgetBgOption("mint", "نعنایی", Color(0xFFE8F5EE)),
    WidgetBgOption("sky", "آبی روشن", Color(0xFFE7F1FB)),
    WidgetBgOption("peach", "هلویی", Color(0xFFFDEEE4)),
    WidgetBgOption("rose", "صورتی", Color(0xFFFBE9EF)),
    WidgetBgOption("lemon", "لیمویی", Color(0xFFFBF6D9)),
    WidgetBgOption("ice", "یخی", Color(0xFFE3F6F8)),
    WidgetBgOption("lilac", "یاسی", Color(0xFFEDE4F8)),
    WidgetBgOption("dark", "تیره", Color(0xFF1F1B29)),
    WidgetBgOption("navy", "سرمه‌ای", Color(0xFF14213D)),
    WidgetBgOption("plum", "آلویی", Color(0xFF2E1A3C)),
    WidgetBgOption("graphite", "گرافیتی", Color(0xFF26282C)),
)

private val LightText = Color(0xFF2A2133)
private val LightMuted = Color(0xFF6B6178)
private val DarkPurple = Color(0xFF4A148C)
private val LightLine = Color(0x594A148C)

private fun light(bg: Long, selected: Long) = WidgetPalette(
    bg = Color(bg),
    text = LightText,
    muted = LightMuted,
    accent = DarkPurple,
    line = LightLine,
    selected = Color(selected),
    dark = false,
)

private fun darkPalette(bg: Long, selected: Long, accent: Long) = WidgetPalette(
    bg = Color(bg),
    text = Color(0xFFF1ECF8),
    muted = Color(0xFFA79FB5),
    accent = Color(accent),
    line = Color(accent).copy(alpha = 0.4f),
    selected = Color(selected),
    dark = true,
)

fun widgetPalette(id: String): WidgetPalette = when (id) {
    "white" -> light(0xFFFFFFFF, 0xFFEFE7F7)
    "mint" -> light(0xFFE8F5EE, 0xFFCBE8D8)
    "sky" -> light(0xFFE7F1FB, 0xFFCFE3F7)
    "peach" -> light(0xFFFDEEE4, 0xFFF9D9C3)
    "rose" -> light(0xFFFBE9EF, 0xFFF5CCD9)
    "lemon" -> light(0xFFFBF6D9, 0xFFF3E9A8)
    "ice" -> light(0xFFE3F6F8, 0xFFBFE8EC)
    "lilac" -> light(0xFFEDE4F8, 0xFFD9C7F0)
    "navy" -> darkPalette(0xFF14213D, 0xFF2A3C66, 0xFFB8C7F0)
    "plum" -> darkPalette(0xFF2E1A3C, 0xFF47295E, 0xFFE0B8F5)
    "graphite" -> darkPalette(0xFF26282C, 0xFF3A3D43, 0xFFD1B3F5)
    "dark" -> WidgetPalette(
        bg = Color(0xFF1F1B29),
        text = Color(0xFFF1ECF8),
        muted = Color(0xFFA79FB5),
        accent = Color(0xFFD1B3F5),
        line = Color(0x66D1B3F5),
        selected = Color(0xFF3B3050),
        dark = true,
    )
    else -> light(0xFFF7F3FB, 0xFFE6DAF3)
}
