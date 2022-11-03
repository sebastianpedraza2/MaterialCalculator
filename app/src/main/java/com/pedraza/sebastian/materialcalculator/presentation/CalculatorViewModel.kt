package com.pedraza.sebastian.materialcalculator.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pedraza.sebastian.materialcalculator.domain.CalculatorAction
import com.pedraza.sebastian.materialcalculator.domain.ExpressionWriter

class CalculatorViewModel(private val expressionWriter: ExpressionWriter = ExpressionWriter()) : ViewModel() {
    var expression by mutableStateOf("")
        private set

    fun processAction(calculatorAction: CalculatorAction) {
        this.expressionWriter.processAction(calculatorAction)
        expression = this.expressionWriter.expression
    }
}