package com.github.alexxxdev.rotadilavk.rule

class CustomRule(override val message: String, val function: (String) -> Boolean) : IRule {
    override fun check(text: String): Boolean {
        return function(text)
    }
}