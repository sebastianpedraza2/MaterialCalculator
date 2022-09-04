package com.pedraza.sebastian.materialcalculator.domain

import androidx.annotation.VisibleForTesting
import com.pedraza.sebastian.materialcalculator.domain.Operation.*

class ExpressionWriter {

    var expression = ""

    fun processAction(action: CalculatorAction) {
        when (action) {
            CalculatorAction.Calculate -> {
                val expressionParser = ExpressionParser(prepareForCalculation())
                val expressionEvaluator = ExpressionEvaluator(expressionParser.parse())
                expression = expressionEvaluator.evaluate().toString()
            }
            CalculatorAction.Clear -> {
                expression = ""
            }
            CalculatorAction.Decimal -> {
                if (canBeDecimal()) {
                    expression += "."
                }
            }
            CalculatorAction.Delete -> {
                expression = expression.dropLast(1)
            }
            is CalculatorAction.Number -> {
                expression += action.number
            }
            is CalculatorAction.Op -> {
                if (canEnterOperation(action)) {
                    expression += action.operation.symbol
                }
            }
            CalculatorAction.Parentheses -> {
                parseParentheses()
            }
        }

    }

    private fun canEnterOperation(action: CalculatorAction.Op): Boolean {
        //If operation is +- -> last char can be "+-/%*9-0()"
        //If operations is */% -> can not be the 1 char and last char can be "9-0)"
        if (action.operation in listOf(
                Add,
                Subtract
            )
        ) return expression.isEmpty() || expression.last() in "${operationSymbols}()1234567890"
        return expression.isNotEmpty() && expression.last() in "1234567890)"
    }

    private fun canBeDecimal(): Boolean {
        if (expression.isEmpty() || expression.last() in "$operationSymbols.()") return false
        return !expression.takeLastWhile {
            it in "1234657890."
        }.contains(".")
    }

    private fun parseParentheses() {
        val openingParenthesesCount = expression.count { it == '(' }
        val closingParenthesesCount = expression.count { it == ')' }
        expression += when {
            expression.isEmpty() || expression.last() in "$operationSymbols(" -> '('
            openingParenthesesCount == closingParenthesesCount && expression.last() in "1234567890.)" -> return
            else -> ')'
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal fun prepareForCalculation(): String {
        val newExpression = expression.dropLastWhile { it in "$operationSymbols(." }
        if (newExpression.isEmpty()) return "0"
        return newExpression
    }
}
