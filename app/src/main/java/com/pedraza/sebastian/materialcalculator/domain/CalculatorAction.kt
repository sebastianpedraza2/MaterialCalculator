package com.pedraza.sebastian.materialcalculator.domain

sealed interface CalculatorAction {
    data class Number(val number: Int) : CalculatorAction
    data class Op(val operation: Operation) : CalculatorAction
    object Parentheses : CalculatorAction
    object Decimal : CalculatorAction
    object Clear : CalculatorAction
    object Delete : CalculatorAction
    object Calculate : CalculatorAction
}