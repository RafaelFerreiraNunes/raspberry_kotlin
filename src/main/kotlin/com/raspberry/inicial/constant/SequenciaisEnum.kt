package com.raspberry.inicial.constant

enum class SequencialEnum(val sequencial: String) {
    SIMPLES("simples"),
    CUMULATIVO("cumulativo"),
    FECHAMENTO("fechamento"),
    ABERTURA("abertura");

    companion object {
        fun getSequencial(valor: String): SequencialEnum? {
            return entries.find { it.sequencial == valor }
        }
    }
}