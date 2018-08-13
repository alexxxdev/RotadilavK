package com.github.alexxxdev.rotadilavk

import com.github.alexxxdev.rotadilavk.field.Field

class Validator(vararg val field: Field) {
    var enableTrim:Boolean = false

    fun validate(): Boolean {
        val error = listOf(*field)
                .map { it.check(enableTrim) }
                .filter { it.hasError }
                .map {
                    it.setWatcher()
                    return@map it.hasError
                }
                .firstOrNull { it }
        return error != true
    }

    fun setErrors(errors: Map<String, String>) {
        errors.map { entry ->
            val field = listOf(*field).firstOrNull { it.field == entry.key }
            field?.apply {
                setError(entry.value)
                setWatcher()
            }
        }
    }

    fun enableTrim(enable: Boolean): Validator {
        enableTrim = enable
        return this
    }
}