package com.github.alexxxdev.rotadilavk.rule

class LengthRule(val minThreshold:Int, val maxThreshold:Int, override val message: String) : IRule {
    override fun check(text: String): Boolean {
        return text.length in minThreshold..maxThreshold
    }
}