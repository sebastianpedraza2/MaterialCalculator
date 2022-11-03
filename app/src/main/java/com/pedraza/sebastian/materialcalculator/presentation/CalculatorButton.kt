package com.pedraza.sebastian.materialcalculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

@Composable
fun CalculatorButton(
    action: CalculatorUiAction,
    modifier: Modifier = Modifier,
    callToAction: () -> Unit
) {
    Box(
        modifier = modifier
            .aspectRatio(ratio = 1f)
            .clip(shape = CircleShape)
            .background(
                color = when (action.highlightLevel) {
                    HighlightLevel.Neutral -> MaterialTheme.colorScheme.surfaceVariant
                    HighlightLevel.SemiHighlighted -> MaterialTheme.colorScheme.inverseSurface
                    HighlightLevel.Highlighted -> MaterialTheme.colorScheme.tertiary
                    HighlightLevel.StronglyHighlighted -> MaterialTheme.colorScheme.primary
                }
            )
            .clickable { callToAction.invoke() },
        contentAlignment = Alignment.Center
    ) {
        if (action.text != null) {
            Text(
                text = action.text,
                color = when (action.highlightLevel) {
                    is HighlightLevel.Neutral -> MaterialTheme.colorScheme.onSurfaceVariant
                    is HighlightLevel.SemiHighlighted -> MaterialTheme.colorScheme.inverseOnSurface
                    is HighlightLevel.Highlighted -> MaterialTheme.colorScheme.onTertiary
                    is HighlightLevel.StronglyHighlighted -> MaterialTheme.colorScheme.onPrimary

                },
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            action.content.invoke()
        }


    }
}
