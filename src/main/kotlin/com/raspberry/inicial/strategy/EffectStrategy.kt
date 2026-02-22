package com.raspberry.inicial.strategy

interface EffectStrategy {
    fun generateEffect(): Array<Array<Boolean>>
}