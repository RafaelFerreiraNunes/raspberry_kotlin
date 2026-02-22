package com.raspberry.inicial.factory

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalOutput
import com.pi4j.io.gpio.digital.DigitalState

fun ledFactory(pi4j: Context, pin: Int, id: String): DigitalOutput =
    pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
    .address(pin)
    .id(id)
    .provider("gpiod-digital-output")
    .shutdown(DigitalState.LOW)
    .initial(DigitalState.LOW)
    .build()).also {
        println("Led $id criado!")
}

fun ledFactoryLet(pi4j: Context, pin: Int, id: String): DigitalOutput =
    pi4j.create(DigitalOutput.newConfigBuilder(pi4j).let {
        it.address(pin)
        it.id(id)
        it.provider("gpiod-digital-output")
        it.shutdown(DigitalState.LOW)
        it.initial(DigitalState.LOW)
        it.build()
    }
)

fun ledFactoryApply(pi4j: Context, pin: Int, id: String): DigitalOutput =
    pi4j.create(DigitalOutput.newConfigBuilder(pi4j).apply {
        address(pin)
        id(id)
        provider("gpiod-digital-output")
        shutdown(DigitalState.LOW)
        initial(DigitalState.LOW)
    }.build()
)