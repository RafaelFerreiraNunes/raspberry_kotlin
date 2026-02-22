package com.raspberry.inicial.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Component
annotation class Strategy(
    @get:AliasFor(annotation = Component::class, attribute = "value")
    val name: String
)