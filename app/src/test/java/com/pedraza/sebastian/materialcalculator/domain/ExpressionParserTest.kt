package com.pedraza.sebastian.materialcalculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionParserTest {

    private lateinit var expressionParser: ExpressionParser

    @Test
    fun `Simple expression is properly parsed`() {

        //Given
        expressionParser = ExpressionParser("4x5/4+45-4")
        //Do something with given
        val actual = expressionParser.parse()
        val expected = mutableListOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.Multiply),
            ExpressionPart.Number(5.0),
            ExpressionPart.Op(Operation.Divide),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.Addition),
            ExpressionPart.Number(45.0),
            ExpressionPart.Op(Operation.Subtract),
            ExpressionPart.Number(4.0),
        )
        //Then assert
        assertThat(actual).isEqualTo(expected)
    }


    @Test
    fun `Expression with parenthesis is properly parsed`() {

        //Given
        expressionParser = ExpressionParser("(4x5)/4+45-(4%5)")
        //Do something with given
        val actual = expressionParser.parse()
        val expected = mutableListOf(
            ExpressionPart.Parenthesis(ParenthesisType.Opening),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.Multiply),
            ExpressionPart.Number(5.0),
            ExpressionPart.Parenthesis(ParenthesisType.Closing),
            ExpressionPart.Op(Operation.Divide),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.Addition),
            ExpressionPart.Number(45.0),
            ExpressionPart.Op(Operation.Subtract),
            ExpressionPart.Parenthesis(ParenthesisType.Opening),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.Percent),
            ExpressionPart.Number(5.0),
            ExpressionPart.Parenthesis(ParenthesisType.Closing),

            )
        //Then assert
        assertThat(actual).isEqualTo(expected)
    }

}