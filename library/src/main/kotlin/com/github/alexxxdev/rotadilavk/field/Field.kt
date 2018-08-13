package com.github.alexxxdev.rotadilavk.field

import android.text.Editable
import android.text.TextWatcher
import com.github.alexxxdev.rotadilavk.rule.IRule
import com.google.android.material.textfield.TextInputLayout

class Field(val inputLayout: TextInputLayout, val rule: IRule, val field: String?=null) {

    var hasError: Boolean = false

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = Unit

        override fun afterTextChanged(s: Editable) {
            inputLayout.isErrorEnabled = false
            inputLayout.editText?.removeTextChangedListener(this)
        }
    }

    fun check(enableTrim: Boolean): Field {
        inputLayout.editText?.let {
            if(enableTrim) it.setText(it.text.trim())

            hasError = !rule.check(it.text.toString())

            if (hasError) inputLayout.error = rule.message
        }
        return this
    }

    fun setWatcher() {
        inputLayout.editText?.let {
            it.removeTextChangedListener(textWatcher)
            it.addTextChangedListener(textWatcher)
        }
    }

    fun setError(value: String) {
        hasError = true
        inputLayout.error = value
    }
}