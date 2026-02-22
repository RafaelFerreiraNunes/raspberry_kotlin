package com.raspberry.inicial.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import com.raspberry.inicial.service.LedManager
import com.raspberry.inicial.constant.SequencialEnum
import com.raspberry.inicial.data.EffectData
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/led")
class LedController(private val ledManager: LedManager) {

    @GetMapping("/{type}")
    fun sequencial(@PathVariable type: String, effect: EffectData): String {

        println("$type")

        val effectEnum = SequencialEnum.getSequencial(type)

        println("$effectEnum")

        ledManager.mudarEfeito(effectEnum)

        return if (effectEnum != null) {"Comando de ligar ${effectEnum.name} recebido!"} else { "looping pausado" }
    }

}