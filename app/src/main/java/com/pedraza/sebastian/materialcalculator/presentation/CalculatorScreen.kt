package com.pedraza.sebastian.materialcalculator.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel = viewModel()
) {
    val uiState = viewModel.expression

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorDisplay(
                expression = uiState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(weight = 1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            CalculatorButtonGrid(
                calculatorActionList = calculatorActionList,
                callToAction = viewModel::processAction,
                modifier = Modifier.padding(8.dp)
            )

        }
    }

}