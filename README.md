# RotadilavK
Android validation library which helps developer boil down the tedious work up to a few simple steps

# Use:
```Groovy
com.github.alexxxdev.RotadilavK:rotadilavk-support-v4:master
```
or
```Groovy
com.github.alexxxdev.RotadilavK:rotadilavk-androidx:master
```

```Kotlin
 val validator:Validator by lazy {
        Validator(
                Field(
                        inputLayout = emailInputLayout,
                        rule = CustomRule(getString(R.string.error_field_required)) {
                            true
                        }
                ),
                Field(passwordInputLayout, RegexRule("^[a-zA-Z]{6,12}", getString(R.string.error_field_required)))
        ).enableTrim(true)
    }

...

    if(validator.validate()){
    }
```
