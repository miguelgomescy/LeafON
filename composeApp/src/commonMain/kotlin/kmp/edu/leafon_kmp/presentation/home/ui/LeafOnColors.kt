package kmp.edu.leafon_kmp.presentation.home.ui

import androidx.compose.ui.graphics.Color

// ─────────────────────────────────────────────────────────────────────────────
// LeafOnColors.kt
//
// Sistema de design centralizado (paleta Leaf.ON Core).
// Centralizar as cores em um object evita que diferentes composables usem
// valores hex "mágicos" espalhados pelo código — qualquer ajuste de paleta
// é feito em um único lugar.
//
// Quando você evoluir para um MaterialTheme completo (recomendado), este
// object pode ser convertido diretamente em um ColorScheme do Material 3.
// ─────────────────────────────────────────────────────────────────────────────

object LeafOnColors {

    // ── Primárias ─────────────────────────────────────────────────────────────
    val GreenPrimary   = Color(0xFF2E7D32)
    val GreenHover     = Color(0xFF4CAF50)
    val GreenLight     = Color(0xFF8BC34A)

    // ── Backgrounds ──────────────────────────────────────────────────────────
    val BgMain         = Color(0xFFFFFFFF)
    val BgSecondary    = Color(0xFFF5F5F5)
    val BgSoftGreen    = Color(0xFFE8F5E9)

    // ── Textos ────────────────────────────────────────────────────────────────
    val TextPrimary    = Color(0xFF212121)
    val TextSecondary  = Color(0xFF757575)
    val TextOnDark     = Color(0xFFFFFFFF)

    // ── Bordas ────────────────────────────────────────────────────────────────
    val BorderDefault  = Color(0xFFE0E0E0)
    val BorderFocus    = Color(0xFF4CAF50)

    // ── Estados / Feedback ────────────────────────────────────────────────────
    val Success        = Color(0xFF43A047)
    val Error          = Color(0xFFE53935)
    val Warning        = Color(0xFFFBC02D)
}
