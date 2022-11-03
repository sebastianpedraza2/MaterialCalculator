package com.pedraza.sebastian.materialcalculator.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pedraza.sebastian.materialcalculator.domain.CalculatorAction

@Composable
fun CalculatorButtonGrid(
    calculatorActionList: List<CalculatorUiAction>,
    modifier: Modifier = Modifier,
    callToAction: (CalculatorAction) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        userScrollEnabled = false,
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items = calculatorActionList) { action ->
            CalculatorButton(action = action) {
                callToAction.invoke(action.action)
            }
        }
    }

}