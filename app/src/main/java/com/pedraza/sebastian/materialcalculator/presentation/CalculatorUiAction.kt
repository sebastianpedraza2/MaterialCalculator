package com.pedraza.sebastian.materialcalculator.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.pedraza.sebastian.materialcalculator.domain.CalculatorAction

data class CalculatorUiAction(
    val text: String? = null,
    val action: CalculatorAction,
    val highlightLevel: HighlightLevel,
    val content: @Composable () -> Unit = {}
)

sealed interface HighlightLevel {
    object Highlighted : HighlightLevel
    object SemiHighlighted : HighlightLevel
    object Neutral : HighlightLevel
    object StronglyHighlighted : HighlightLevel
}


@Composable
fun HighlightLevel.getColorFromHighlightLevel(): Color {
   return  when (this) {
        HighlightLevel.Highlighted -> {
            MaterialTheme.colorScheme.primary
        }
        HighlightLevel.Neutral -> {
            MaterialTheme.colorScheme.primary
        }
        HighlightLevel.SemiHighlighted -> MaterialTheme.colorScheme.primary
        HighlightLevel.StronglyHighlighted -> MaterialTheme.colorScheme.primary
    }
}
