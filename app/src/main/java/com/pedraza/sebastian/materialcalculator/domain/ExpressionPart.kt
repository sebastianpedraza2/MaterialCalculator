package com.pedraza.sebastian.materialcalculator.domain

sealed interface ExpressionPart {
    data class Parenthesis(val parenthesisType: ParenthesisType) : ExpressionPart
    data class Op(val operation: Operation) : ExpressionPart
    data class Number(val number: Double) : ExpressionPart
}

sealed interface ParenthesisType {
    object Opening : ParenthesisType
    object Closing : ParenthesisType
}