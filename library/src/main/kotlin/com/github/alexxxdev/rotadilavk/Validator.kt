package com.github.alexxxdev.rotadilavk

class Validator(vararg val field: Field) {
    fun validate(): Boolean {
        val error = listOf(*field)
                .map { it.check() }
                .filter { it.hasError }
                .map {
                    it.setWatcher()
                    return@map it.hasError
                }
                .firstOrNull { it }
        return error != true
    }

    fun setErrors(errors: Map<String, String>) {
        errors.map {
            entry ->
            val field = listOf(*field).firstOrNull { it.field == entry.key }
            field?.apply {
                setError(entry.value)
                setWatcher()
            }
        }
    }
}