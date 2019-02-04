package com.art

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class TemperatureTest {

    @Test
    fun `test kelvin to celsius`() {
        val input = 20f
        val output = -253.15f

        assertThat(Temperature(kelvin = input).celsius).isEqualTo(output)
    }

    @Test
    fun `test kelvin to fahrenheit`() {
        val input = 20f
        val output = -423.67f

        assertThat(Temperature(kelvin = input).fahrenheit).isEqualTo(output)
    }

    @Test
    fun `test celsius to kelvin`() {
        val input = 15f
        val output = 288.15f

        assertThat(Temperature(celsius = input).kelvin).isEqualTo(output)
    }

    @Test
    fun `test celsius to fahrenheit`() {
        val input = 15f
        val output = 59f

        assertThat(Temperature(celsius = input).fahrenheit).isEqualTo(output)
    }

    @Test
    fun `test fahrenheit to kelvin`() {
        val input = 36f
        val output = 275.37f

        assertThat(Temperature(fahrenheit = input).kelvin).isEqualTo(output)
    }

    @Test
    fun `test fahrenheit to celsius`() {
        val input = 36f
        val output = 2.22f

        assertThat(Temperature(fahrenheit = input).celsius).isEqualTo(output)
    }

    @Test
    fun `test without parameter`() {
        assertThrows<IllegalArgumentException> { Temperature() }
    }
}