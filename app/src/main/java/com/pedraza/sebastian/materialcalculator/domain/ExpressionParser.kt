package com.pedraza.sebastian.materialcalculator.domain

class ExpressionParser(private val calculation: String) {

    fun parse(): List<ExpressionPart> {
        val result = mutableListOf<ExpressionPart>()
        var i = 0
        while (i < calculation.length) {
            when {
                calculation[i].isDigit() -> {
                    i = parseNumber(i, result)
                    continue
                }
                calculation[i] in operationSymbols -> {
                    result.add(ExpressionPart.Op(operationFromSymbol(calculation[i])))
                }
                calculation[i] in "()" -> {
                    parseParenthesis(calculation[i], result)
                }
                else -> throw IllegalArgumentException("Character not supported")
            }
            i++
        }

        return result
    }

    private fun parseNumber(startingPos: Int, result: MutableList<ExpressionPart>): Int {
        var i = startingPos
        val number = buildString {
            while (i < calculation.length && calculation[i] in NUMBERS) {
                append(calculation[i])
                i++
            }
        }.toDouble()
        result.add(ExpressionPart.Number(number))
        return i

    }

    private fun parseParenthesis(currChar: Char, result: MutableList<ExpressionPart>) {
        result.add(
            ExpressionPart.Parentheses(
                when (currChar) {
                    '(' -> {
                        ParenthesesType.Opening
                    }
                    ')' -> {
                        ParenthesesType.Closing
                    }
                    else -> {
                        throw IllegalArgumentException("Parenthesis type not supported")
                    }
                }

            )
        )
    }

    companion object {
        const val NUMBERS = "1234567890."
    }
}