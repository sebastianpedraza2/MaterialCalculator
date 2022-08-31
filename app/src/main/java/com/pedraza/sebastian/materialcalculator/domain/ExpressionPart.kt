package com.pedraza.sebastian.materialcalculator.domain

sealed interface ExpressionPart {
    data class Parentheses(val parenthesesType: ParenthesesType) : ExpressionPart
    data class Op(val operation: Operation) : ExpressionPart
    data class Number(val number: Double) : ExpressionPart
}

sealed interface ParenthesesType {
    object Opening : ParenthesesType
    object Closing : ParenthesesType
}