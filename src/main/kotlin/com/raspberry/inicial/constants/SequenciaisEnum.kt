package com.raspberry.inicial.constants

enum class SequencialEnum(val sequencial: String) {
    SIMPLES("simples"),
    CUMULATIVO("cumulativo"),
    FECHAMENTO("fechamento"),
    ABERTURA("abertura");

    companion object {
        fun getSequencial(valor: String): SequencialEnum? {
            return entries.find { it.name == valor }
        }
    }
}