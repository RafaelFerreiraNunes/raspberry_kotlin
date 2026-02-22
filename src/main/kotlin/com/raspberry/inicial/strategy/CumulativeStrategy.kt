package com.raspberry.inicial.strategy

import com.raspberry.inicial.annotation.Strategy

@Strategy("cumulativo")
class CumulativeStrategy(): EffectStrategy {
    override fun generateEffect(): Array<Array<Boolean>> {
        return arrayOf(
            arrayOf(false, false, false, false, false, false),
            arrayOf(false, false, false, false, false, true),
            arrayOf(false, false, false, false, true, false),
            arrayOf(false, false, false, true, false, false),
            arrayOf(false, false, true, false, false, false),
            arrayOf(false, true, false, false, false, false),
            arrayOf(true, false, false, false, false, false),
            arrayOf(true, false, false, false, false, true),
            arrayOf(true, false, false, false, true, false),
            arrayOf(true, false, false, true, false, false),
            arrayOf(true, false, true, false, false, false),
            arrayOf(true, true, false, false, false, false),
            arrayOf(true, true, false, false, false, true),
            arrayOf(true, true, false, false, true, false),
            arrayOf(true, true, false, true, false, false),
            arrayOf(true, true, true, false, false, false),
            arrayOf(true, true, true, false, false, true),
            arrayOf(true, true, true, false, true, false),
            arrayOf(true, true, true, true, false, false),
            arrayOf(true, true, true, true, false, true),
            arrayOf(true, true, true, true, true, false),
            arrayOf(true, true, true, true, true, true)
        )
    }
}