package com.pedraza.sebastian.materialcalculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionEvaluatorTest {

    private lateinit var expressionEvaluator: ExpressionEvaluator

    @Test
    fun `ExpressionEvaluator evaluates simple expression correctly`() {
        //given
        expressionEvaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Op(Operation.Add),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.Subtract),
                ExpressionPart.Number(3.0),
                ExpressionPart.Op(Operation.Multiply),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.Divide),
                ExpressionPart.Number(3.0),
            )
        )
        //When, do something with given
        val actual = expressionEvaluator.evaluate()

        //Then
        assertThat(actual).isEqualTo(4)
    }

    @Test
    fun `ExpressionEvaluator evaluates expression with decimals correctly`() {
        //given
        expressionEvaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.5),
                ExpressionPart.Op(Operation.Add),
                ExpressionPart.Number(5.5),
                ExpressionPart.Op(Operation.Subtract),
                ExpressionPart.Number(3.5),
                ExpressionPart.Op(Operation.Multiply),
                ExpressionPart.Number(5.5),
                ExpressionPart.Op(Operation.Divide),
                ExpressionPart.Number(3.5),
            )
        )
        //When, do something with given
        val actual = expressionEvaluator.evaluate()

        //Then
        assertThat(actual).isEqualTo(4.5)
    }


    @Test
    fun `ExpressionEvaluator evaluates expression with parenthesis correctly`() {
        //given
        expressionEvaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Op(Operation.Add),
                ExpressionPart.Parentheses(ParenthesesType.Opening),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.Subtract),
                ExpressionPart.Number(3.0),
                ExpressionPart.Parentheses(ParenthesesType.Closing),
                ExpressionPart.Op(Operation.Multiply),
                ExpressionPart.Number(5.0),
                ExpressionPart.Op(Operation.Divide),
                ExpressionPart.Number(4.0),
            )
        )
        //When, do something with given
        val actual = expressionEvaluator.evaluate()

        //Then
        assertThat(actual).isEqualTo(6.5)
    }

    @Test
    fun `ExpressionEvaluator evaluates expression with nested parentheses correctly`() {
        //given
        expressionEvaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Op(Operation.Multiply),
                ExpressionPart.Number(3.0),
                ExpressionPart.Op(Operation.Add),
                ExpressionPart.Parentheses(ParenthesesType.Opening),
                ExpressionPart.Parentheses(ParenthesesType.Opening),
                ExpressionPart.Number(3.0),
                ExpressionPart.Op(Operation.Add),
                ExpressionPart.Number(3.0),
                ExpressionPart.Parentheses(ParenthesesType.Closing),
                ExpressionPart.Op(Operation.Divide),
                ExpressionPart.Number(45.0),
                ExpressionPart.Parentheses(ParenthesesType.Closing),
            )
        )
        //When, do something with given
        val actual = expressionEvaluator.evaluate()

        //Then
        assertThat(actual).isEqualTo(12.133333333333333)
    }
}