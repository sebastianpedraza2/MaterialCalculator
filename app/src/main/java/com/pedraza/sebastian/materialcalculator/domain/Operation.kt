package com.pedraza.sebastian.materialcalculator.domain

enum class Operation(val symbol: Char) {
    Add('+'),
    Subtract('-'),
    Multiply('x'),
    Divide('/'),
    Percent('%')
}

//String containing all the supported symbols "+-*/%"
val operationSymbols = Operation.values().map { it.symbol }.joinToString("")

fun operationFromSymbol(symbol: Char): Operation {
    return Operation.values().find { it.symbol == symbol }
        ?: throw IllegalArgumentException("Symbol not supported")
}