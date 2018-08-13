package com.github.alexxxdev.rotadilavk.field

abstract class AbstractField(val field: String? = null) {
    var hasError: Boolean = false
    abstract fun check(enableTrim: Boolean): AbstractField
    abstract fun setWatcher()
    abstract fun setError(value: String)
}