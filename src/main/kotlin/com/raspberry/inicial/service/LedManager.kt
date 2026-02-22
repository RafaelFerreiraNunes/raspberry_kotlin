package com.raspberry.inicial.service

import com.pi4j.Pi4J
import com.pi4j.io.gpio.digital.DigitalOutput
import com.raspberry.inicial.constant.SequencialEnum
import com.raspberry.inicial.data.EffectData
import com.raspberry.inicial.factory.ledFactory
import com.raspberry.inicial.factory.ledFactoryApply
import com.raspberry.inicial.factory.ledFactoryLet
import jakarta.annotation.PostConstruct
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service

@Service
class LedManager(private val effectData: EffectData) {

    private val pi4j = Pi4J.newAutoContext()

    private val led1 = ledFactory(pi4j, 18, "led1-pin12")
    private val led2 = ledFactory(pi4j, 23, "led2-pin16")
    private val led3 = ledFactoryLet(pi4j, 24, "led3-pin18")
    private val led4 = ledFactoryLet(pi4j, 25, "led4-pin22")
    private val led5 = ledFactoryApply(pi4j, 8, "led5-pin24")
    private val led6 = ledFactoryApply(pi4j, 7, "led6-pin26")

    private var efeitoAtual: SequencialEnum? = null

    private val scope = CoroutineScope(Dispatchers.Default + Job())

    @PostConstruct
    fun iniciarLoop() {
        scope.launch {
            while (isActive) {
                val efeito = efeitoAtual
                if (efeito != null) {
                    val matrix = effectData.efeitos[efeito]
                    matrix?.forEach { line ->
                        if (efeito != efeitoAtual) return@forEach
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
                        delay(400)
                    }
                } else {
                    actionLed(led1, false)
                    actionLed(led2, false)
                    actionLed(led3, false)
                    actionLed(led4, false)
                    actionLed(led5, false)
                    actionLed(led6, false)
                }
            }
        }
    }

    fun mudarEfeito(novoEfeito: SequencialEnum?) {
        this.efeitoAtual = novoEfeito
    }
}

fun actionLed(led: DigitalOutput, action: Boolean) {
    if(action) led.high() else led.low()
}