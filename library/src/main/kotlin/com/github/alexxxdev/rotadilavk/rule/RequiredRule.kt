package com.github.alexxxdev.rotadilavk.rule

import com.github.alexxxdev.rotadilavk.IRule

class RequiredRule(override val message: String) :IRule {
    override fun check(text: String): Boolean {
        return text.isNotBlank()
    }
}