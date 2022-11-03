package com.pedraza.sebastian.materialcalculator.presentation


import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.pedraza.sebastian.materialcalculator.MainActivity
import org.junit.Rule
import org.junit.Test

class CalculatorScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
     fun enterExpression_correctResultDisplayed(){

        // When
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("÷").performClick()
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("=").performClick()
        // Then
        composeRule.onNodeWithText("5.0").assertIsDisplayed()
    }
}