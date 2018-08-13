package com.github.alexxxdev.rotadilavk.rule

interface IRule {
    val message: String
    fun check(text: String): Boolean
}