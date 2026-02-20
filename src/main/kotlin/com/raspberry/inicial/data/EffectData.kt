package com.raspberry.inicial.data

import com.raspberry.inicial.constant.SequencialEnum
import org.springframework.stereotype.Component

@Component
class EffectData {

    val efeitos: Map<SequencialEnum, Array<Array<Boolean>>> = mapOf(
        SequencialEnum.SIMPLES to arrayOf(
            arrayOf(false, false, false, false, false, false),
            arrayOf(false, false, false, false, false, true),
            arrayOf(false, false, false, false, true, false),
            arrayOf(false, false, false, true, false, false),
            arrayOf(false, false, true, false, false, false),
            arrayOf(false, true, false, false, false, false),
            arrayOf(true, false, false, false, false, false)
        ),
        SequencialEnum.CUMULATIVO to arrayOf(
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
        ),
        SequencialEnum.FECHAMENTO to arrayOf(
            arrayOf(false, false, false, false, false, false),
            arrayOf(true, false, false, false, false, true),
            arrayOf(false, true, false, false, true, false),
            arrayOf(false, false, true, true, false, false)
        ),
        SequencialEnum.ABERTURA to arrayOf(
            arrayOf(false, false, false, false, false, false),
            arrayOf(false, false, true, true, false, false),
            arrayOf(false, true, false, false, true, false),
            arrayOf(true, false, false, false, false, true)
        )
    )
}