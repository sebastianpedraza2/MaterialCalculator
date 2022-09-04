package com.pedraza.sebastian.materialcalculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ExpressionWriterTest{
    private lateinit var expressionWriter: ExpressionWriter

    @Before
    fun setup(){
        expressionWriter = ExpressionWriter()
    }

    @Test
    fun `Expression parsed correctly`(){
        //When (5+4)
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Op(Operation.Add))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Parentheses)
        //Then
        assertThat(expressionWriter.expression).isEqualTo("(5+4)")
    }

    @Test
    fun `Two consecutive parentheses parsed correctly`(){
        //When ((
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Parentheses)
        //Then
        assertThat(expressionWriter.expression).isEqualTo("((")
    }
    @Test
    fun `Two consecutive operations parsed correctly`(){
        //When 5+*4
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Op(Operation.Add))
        expressionWriter.processAction(CalculatorAction.Op(Operation.Multiply))
        expressionWriter.processAction(CalculatorAction.Number(4))
        //Then
        assertThat(expressionWriter.expression).isEqualTo("5+4")
    }

    @Test
    fun `Expression with decimal parsed correctly`(){
        //When 5.45+4.34
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Decimal)
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Op(Operation.Add))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Decimal)
        expressionWriter.processAction(CalculatorAction.Number(3))
        expressionWriter.processAction(CalculatorAction.Number(4))


        //Then
        assertThat(expressionWriter.expression).isEqualTo("5.45+4.34")
    }

    @Test
    fun `Multiple Parentheses opening correctly`(){
        //When
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Op(Operation.Add))
        expressionWriter.processAction(CalculatorAction.Number(4))
        //Then
        assertThat(expressionWriter.expression).isEqualTo("((((5+4")
    }

    @Test
    fun `Delete action working correctly`(){
        //When
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Op(Operation.Multiply))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Decimal)
        expressionWriter.processAction(CalculatorAction.Delete)
        //Then
        assertThat(expressionWriter.expression).isEqualTo("5x4")
    }

    @Test
    fun `PrepareForCalculation working correctly`(){
        //Given
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Op(Operation.Multiply))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Op(Operation.Add))
        //When
        val newExpression = expressionWriter.prepareForCalculation()
        //Then
        assertThat(newExpression).isEqualTo("5x4")
    }

    @Test
    fun `Clear Action working correctly`(){
        //When
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Op(Operation.Multiply))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Clear)
        //Then
        assertThat(expressionWriter.expression).isEqualTo("")
    }
}
