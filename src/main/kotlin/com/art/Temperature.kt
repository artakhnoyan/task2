package com.art

import java.lang.IllegalArgumentException
import kotlin.math.round

//Using args: Array<String> is not a must for latest kotlin version
fun main() {
    val temperature = Temperature(celsius = 38f)
    println(temperature) // Temperature(celsius=38.0)
    println("C 38 = ${temperature.kelvin} Kelvin") // 311,15
    println("C 38 = ${temperature.fahrenheit} Fahrenheit") // 100.4
    temperature.kelvin = 30.0f
    println("K 30 = ${temperature.celsius} Celsius") // -243,15
    val temperatureNew = Temperature(fahrenheit = -405.67f)
    println(temperature == temperatureNew) // true
}

private const val CELSIUS_IN_ZERO_KELVIN: Float = 273.15f
private const val FACTOR_FROM_FAHRENHEIT: Float = 5f / 9
private const val FACTOR_TO_FAHRENHEIT: Float = 9f / 5

class Temperature(kelvin: Float? = null, celsius: Float? = null, fahrenheit: Float? = null) {
    private var _kelvin: Float = 0f
    var kelvin: Float
        get() = _kelvin.roundTo2Dec()
        set(value) {
            _kelvin = value
            _celsius = value - CELSIUS_IN_ZERO_KELVIN
            _fahrenheit = _celsius * FACTOR_TO_FAHRENHEIT + 32
        }
    private var _celsius: Float = 0f
    var celsius: Float
        get() = _celsius.roundTo2Dec()
        set(value) {
            _celsius = value
            _kelvin = value + CELSIUS_IN_ZERO_KELVIN
            _fahrenheit = value * FACTOR_TO_FAHRENHEIT + 32
        }
    private var _fahrenheit: Float = 0f
    var fahrenheit: Float
        get() = _fahrenheit.roundTo2Dec()
        set(value) {
            _fahrenheit = value
            _celsius = (value - 32) * FACTOR_FROM_FAHRENHEIT
            _kelvin = _celsius + CELSIUS_IN_ZERO_KELVIN
        }

    //Couldn't find any nice solution to throw exception if 2 or more arguments are set :'(
    init {
        when {
            kelvin != null -> this.kelvin = kelvin
            celsius != null -> this.celsius = celsius
            fahrenheit != null -> this.fahrenheit = fahrenheit
            else -> throw IllegalArgumentException("must have at least one not nullable argument)")
        }
    }

    private fun Float.roundTo2Dec(): Float = round(this * 100f) / 100f

    override fun equals(other: Any?): Boolean {
        if (other is Temperature) {
            return this.celsius == other.celsius &&
                    this.kelvin == other.kelvin &&
                    this.fahrenheit == other.fahrenheit
        }
        return false
    }

    override fun hashCode(): Int {
        var result = kelvin.hashCode()
        result = 31 * result + celsius.hashCode()
        result = 31 * result + fahrenheit.hashCode()
        return result
    }

    override fun toString(): String {
        return "Temperature(celsius = $celsius)"
    }
}