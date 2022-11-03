package com.pedraza.sebastian.materialcalculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorDisplay(
    modifier: Modifier = Modifier,
    expression: String
) {
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 25.dp,
                    bottomEnd = 25.dp
                )
            )
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .padding(
                vertical = 64.dp,
                horizontal = 16.dp
            ),
        contentAlignment = Alignment.Center

    ) {
        BasicTextField(
            value = expression,
            onValueChange = {},
            textStyle = TextStyle(
                fontSize = 80.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.End
            ),
            maxLines = 1,
            singleLine = true,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )

    }

}