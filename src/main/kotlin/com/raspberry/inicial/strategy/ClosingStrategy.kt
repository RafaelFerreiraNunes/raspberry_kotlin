package com.raspberry.inicial.strategy

import com.raspberry.inicial.annotation.Strategy

@Strategy("fechamento")
class ClosingStrategy(): EffectStrategy {
    override fun generateEffect(): Array<Array<Boolean>> {
        return arrayOf(
            arrayOf(false, false, false, false, false, false),
            arrayOf(true, false, false, false, false, true),
            arrayOf(false, true, false, false, true, false),
            arrayOf(false, false, true, true, false, false)
        )
    }
}