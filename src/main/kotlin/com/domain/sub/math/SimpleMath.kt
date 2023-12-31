package com.domain.sub.math

import kotlin.math.sqrt

class SimpleMath {

    fun sum(
        numberOne: Double, numberTwo: Double
    ) = numberOne + numberTwo

    fun sub(
        numberOne: Double, numberTwo: Double
    ) = numberOne - numberTwo


    fun multiplication(
        numberOne: Double, numberTwo: Double
    ) = numberOne * numberTwo

    fun division(
        numberOne: Double,
        numberTwo: Double,
    ) = numberOne / numberTwo

    fun average(
        numberOne: Double, numberTwo: Double
    ) = (numberOne + numberTwo) / 2

    fun squareRoot(
        number: Double,
    ) = sqrt(number)

}