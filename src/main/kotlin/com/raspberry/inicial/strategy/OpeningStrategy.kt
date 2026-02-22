package com.raspberry.inicial.strategy

import com.raspberry.inicial.annotation.Strategy

@Strategy("abertura")
class OpeningStrategy(): EffectStrategy {
    override fun generateEffect(): Array<Array<Boolean>> {
        return arrayOf(
            arrayOf(false, false, false, false, false, false),
            arrayOf(false, false, true, true, false, false),
            arrayOf(false, true, false, false, true, false),
            arrayOf(true, false, false, false, false, true)
        )
    }
}