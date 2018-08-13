package com.github.alexxxdev.rotadilavk

interface IRule {
    val message: String
    fun check(text: String): Boolean
}