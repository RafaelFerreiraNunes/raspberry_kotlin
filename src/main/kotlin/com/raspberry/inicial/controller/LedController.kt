package com.raspberry.inicial.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import com.pi4j.Pi4J
import com.pi4j.io.gpio.digital.DigitalOutput
import com.raspberry.inicial.LedManager
import com.raspberry.inicial.constants.SequencialEnum
import com.raspberry.inicial.data.EffectData
import com.raspberry.inicial.factories.ledFactory
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties
import org.springframework.web.bind.annotation.PathVariable
import java.lang.Thread.sleep

@RestController
@RequestMapping("/led")
class LedController(private val ledManager: LedManager) {

    @GetMapping("/{type}")
    fun sequencial(@PathVariable type: String, effect: EffectData): String {
        val effectEnum = SequencialEnum.getSequencial(type)

        ledManager.mudarEfeito(effectEnum)

        return if (effectEnum != null) {"Comando de ligar ${effectEnum.name} recebido!"} else { "looping pausado" }
    }

    fun actionLed(led: DigitalOutput, action: Boolean) {
        if(action) led.high() else led.low()
    }

}

