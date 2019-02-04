package com.art.calculator


abstract class Operator {
    abstract val operator: String
    abstract val priority: Int
    abstract fun operate(firstValue: Float, secondValue: Float): Float
}

operator fun Operator.compareTo(other: Operator): Int = this.priority - other.priority

object Plus : Operator() {
    override val operator: String
        get() = "+"
    override val priority: Int
        get() = 1

    override fun operate(firstValue: Float, secondValue: Float): Float = firstValue + secondValue

}

object Minus : Operator() {
    override val operator: String
        get() = "-"
    override val priority: Int
        get() = 1

    override fun operate(firstValue: Float, secondValue: Float): Float = firstValue - secondValue

}

object Multiply : Operator() {
    override val operator: String
        get() = "*"
    override val priority: Int
        get() = 2

    override fun operate(firstValue: Float, secondValue: Float): Float = firstValue * secondValue

}

object Divide : Operator() {
    override val operator: String
        get() = "/"
    override val priority: Int
        get() = 3

    override fun operate(firstValue: Float, secondValue: Float): Float = firstValue / secondValue

}

object RightParentheses : Operator() {
    override val operator: String
        get() = ")"
    override val priority: Int
        get() = -1

    override fun operate(firstValue: Float, secondValue: Float): Float =
        throw IllegalAccessException("this operator cannot operate")

}

object LeftParentheses : Operator() {
    override val operator: String
        get() = "9"
    override val priority: Int
        get() = -1

    override fun operate(firstValue: Float, secondValue: Float): Float =
        throw IllegalAccessException("this operator cannot operate")

}