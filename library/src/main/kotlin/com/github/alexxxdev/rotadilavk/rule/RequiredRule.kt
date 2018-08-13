package com.github.alexxxdev.rotadilavk.rule

class RequiredRule(override val message: String) : IRule {
    override fun check(text: String): Boolean {
        return text.isNotBlank()
    }
}