package com.raspberry.inicial.factories

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalOutput
import com.pi4j.io.gpio.digital.DigitalState

fun ledFactory(pi4j: Context, pin: Int, id: String): DigitalOutput = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
    .address(pin)
    .id(id)
    .provider("gpiod-digital-output")
    .shutdown(DigitalState.LOW)
    .initial(DigitalState.LOW)
    .build())