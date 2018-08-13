package com.github.alexxxdev.rotadilavk.support.v4.field

import android.support.design.widget.TextInputLayout
import android.text.Editable
import android.text.TextWatcher
import com.github.alexxxdev.rotadilavk.field.AbstractField
import com.github.alexxxdev.rotadilavk.rule.IRule

class Field(val inputLayout: TextInputLayout, val rule: IRule, field: String? = null) : AbstractField(field) {

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = Unit

        override fun afterTextChanged(s: Editable) {
            inputLayout.isErrorEnabled = false
            inputLayout.editText?.removeTextChangedListener(this)
        }
    }

    override fun check(enableTrim: Boolean): Field {
        inputLayout.editText?.let {
            if(enableTrim) it.setText(it.text.trim())

            hasError = !rule.check(it.text.toString())

            if (hasError) inputLayout.error = rule.message
        }
        return this
    }

    override fun setWatcher() {
        inputLayout.editText?.let {
            it.removeTextChangedListener(textWatcher)
            it.addTextChangedListener(textWatcher)
        }
    }

    override fun setError(value: String) {
        hasError = true
        inputLayout.error = value
    }
}