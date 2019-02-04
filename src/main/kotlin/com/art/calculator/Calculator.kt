package com.art.calculator

fun main() {
    readLine()?.let { println(Calculator(it.extractExpression()).calculate()) }
}

class Calculator(private val expression: List<String>) {
    private val operators = mutableListOf<Operator>()
    private val values = mutableListOf<Float>()

    fun calculate(): Float {
        for (item in expression) {
            when (item) {
                "+" -> checkPriorityAndOperate(Plus)
                "-" -> checkPriorityAndOperate(Minus)
                "*" -> checkPriorityAndOperate(Multiply)
                "/" -> operators.add(Divide)
                "(" -> operators.add(LeftParentheses)
                ")" -> operateRightParenthesis()
                else -> {
                    values.add(item.toFloat())
                }
            }
        }

        while (!operators.isEmpty()) {
            val value1 = values.getAndRemove(values.lastIndex)
            val value2 = values.getAndRemove(values.lastIndex)

            values.add(operators.last().operate(value2, value1))
            operators.getAndRemove(operators.lastIndex)
        }

        return values[0]
    }

    private fun operateRightParenthesis() {
        while (!operators.isEmpty() && operators.last() != LeftParentheses) {
            operateAndRemove()
        }
        operators.removeAt(operators.lastIndex)
    }

    private fun checkPriorityAndOperate(operator: Operator) {
        if (!operators.isEmpty() && operator <= operators.last()) {
            while (!operators.isEmpty() && operator <= operators.last()) {
                operateAndRemove()
            }
        }
        operators.add(operator)
    }

    private fun operateAndRemove() {
        val value1 = values.getAndRemove(values.lastIndex)
        val value2 = values.getAndRemove(values.lastIndex)
        val operator = operators.getAndRemove(operators.lastIndex)

        values.add(operator.operate(value2, value1))
    }

    private fun <T> MutableList<T>.getAndRemove(index: Int): T {
        val value = get(index)
        removeAt(index)
        return value
    }
}

fun String.extractExpression(): List<String> {
    val result = mutableListOf<String>()
    val input = this.replace(" ", "")
    var lastChar = '\u0000'
    loop@ for (index in input.indices) {
        val current = input[index]
        val nextIndex = index + 1
        when {
            current.isWhitespace() -> continue@loop
            current.isDigit() && lastChar.isDigit() -> result.appendToLastDigit(current.toString())
            lastChar.isSign() && current.isDigit() &&
                    (input.lastIndex > nextIndex && input[nextIndex].isDigit()) -> result.appendToLastDigit(current.toString())
            else -> result.add(current.toString())
        }
        lastChar = current
    }
    println(result)
    return result
}

private fun Char.isSign(): Boolean = this == '-' || this == '+'

private fun MutableList<String>.appendToLastDigit(digit: String) {
    val last = last()
    removeAt(lastIndex)
    add(last + digit)
}

