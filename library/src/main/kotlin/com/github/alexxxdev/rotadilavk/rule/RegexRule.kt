package com.github.alexxxdev.rotadilavk.rule

import com.github.alexxxdev.rotadilavk.IRule

class RegexRule(val regex: String, override val message: String) :IRule {
    override fun check(text: String): Boolean {
        return text.matches(regex.toRegex())
    }
}