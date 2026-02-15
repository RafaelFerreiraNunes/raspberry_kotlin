package com.raspberry.inicial.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import com.pi4j.Pi4J
import com.pi4j.io.gpio.digital.DigitalOutput
import com.pi4j.io.gpio.digital.DigitalState
import com.raspberry.inicial.factories.ledFactory
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties
import java.lang.Thread.sleep

@RestController
@RequestMapping("/led")
class LedController(private val projectInfoProperties: ProjectInfoProperties) {

    private val pi4j = Pi4J.newAutoContext()

    private val led1 = ledFactory(pi4j, 18, "led1-pin12")
    private val led2 = ledFactory(pi4j, 23, "led2-pin16")
    private val led3 = ledFactory(pi4j, 24, "led3-pin18")
    private val led4 = ledFactory(pi4j, 25, "led4-pin22")
    private val led5 = ledFactory(pi4j, 8, "led5-pin24")
    private val led6 = ledFactory(pi4j, 7, "led6-pin26")

    private val matriz = arrayOf(
        arrayOf(false, false, false, false, false, false),
        arrayOf(false, false, false, false, false, true),
        arrayOf(false, false, false, false, true, false),
        arrayOf(false, false, false, true, false, false),
        arrayOf(false, false, true, false, false, false),
        arrayOf(false, true, false, false, false, false),
        arrayOf(true, false, false, false, false, false),
        arrayOf(false, false, false, false, false, false),
    )

    @GetMapping("/on")
    fun on(): String {
        println(">>> Recebido comando para LIGAR o led")
        led1.high().let { "Ligado" }
        matriz.forEach { line ->
            var led = 1
            line.forEach { pin ->
                when (led) {
                    1 -> actionLed(led1, pin)
                    2 -> actionLed(led2, pin)
                    3 -> actionLed(led3, pin)
                    4 -> actionLed(led4, pin)
                    5 -> actionLed(led5, pin)
                    6 -> actionLed(led6, pin)
                }
                led++
            }
            sleep(1000)
        }
        return "Comando de ligar recebido!"
    }

    @GetMapping("/off")
    fun off(): String {
        println(">>> Recebido comando para DESLIGAR o led")
        led1.low().let { "Desligado" }
        return "Comando de desligar recebido!"
    }

    fun actionLed(led: DigitalOutput, action: Boolean) {
        if(action) led.high() else led.low()
    }

}

