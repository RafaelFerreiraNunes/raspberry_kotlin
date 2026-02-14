package com.raspberry.inicial.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import com.pi4j.Pi4J
import com.pi4j.io.gpio.digital.DigitalOutput
import com.pi4j.io.gpio.digital.DigitalState



@RestController
@RequestMapping("/led")
class LedController {

    private val pi4j = Pi4J.newAutoContext()

    private val led = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
    .address(18)
    .id("led")
    .shutdown(DigitalState.LOW)
    .initial(DigitalState.LOW)
    .build())


    @GetMapping("/on")
    fun on(): String {
        led.high().let { "Ligado" }
        return "Comando de ligar recebido!"
    }


    @GetMapping("/off")
    fun off(): String {
        led.low().let { "Desligado" }
        return "Comando de desligar recebido!"
    }

}

