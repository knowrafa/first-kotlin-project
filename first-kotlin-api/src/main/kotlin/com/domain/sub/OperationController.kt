package com.domain.sub

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OperationController {
    @RequestMapping(value=["/sum/{numberOne}/{numberTwo}"])
    fun sum(
            @PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Operation {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw Exception()
        return Operation(convertDouble(numberOne) + convertDouble(numberTwo))
    }

    private fun convertDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}