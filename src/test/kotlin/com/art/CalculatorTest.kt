package com.art

import com.art.calculator.Calculator
import com.art.calculator.extractExpression
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `test minus`() {
        val input = "5 -60"
        val output = -55f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }

    @Test
    fun `test plus`() {
        val input = "5 + 6"
        val output = 11f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }

    @Test
    fun `test multiply`() {
        val input = "5 * 6"
        val output = 30f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }

    @Test
    fun `test divide`() {
        val input = "30 / 6"
        val output = 5f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }

    @Test
    fun `test big expression`() {
        val input = "4 +9 *1 *3 - 14"
        val output = 17f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }

    @Test
    fun `test divied priority`() {
        val input = "2/2*2"
        val output = 2f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }

    @Test
    fun `test parenthesis`() {
        val input = "(2+2)*2"
        val output = 8f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }

    @Test
    fun `test negative`() {
        val input = "2 * 5 +-66 / 3"
        val output = -12f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }

    @Test
    fun `test negative from beginning`() {
        val input = "- 66 / 3"
        val output = -22f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }

    @Test
    fun `test positive with sign`() {
        val input = "+ 66 / 3"
        val output = 22f
        Assertions.assertThat(Calculator(input.extractExpression()).calculate()).isEqualTo(output)
    }
}