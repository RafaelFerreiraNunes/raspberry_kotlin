package com.raspberry.inicial.strategy

import com.raspberry.inicial.annotation.Strategy

@Strategy("simples")
class SimpleStrategy(): EffectStrategy {
    override fun generateEffect(): Array<Array<Boolean>> {
        return arrayOf(
            arrayOf(false, false, false, false, false, false),
            arrayOf(false, false, false, false, false, true),
            arrayOf(false, false, false, false, true, false),
            arrayOf(false, false, false, true, false, false),
            arrayOf(false, false, true, false, false, false),
            arrayOf(false, true, false, false, false, false),
            arrayOf(true, false, false, false, false, false)
        )
    }
}