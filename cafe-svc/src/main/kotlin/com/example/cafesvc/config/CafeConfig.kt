package com.example.cafesvc.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class CafeConfig(
    @Value("\${cafe.name}")
    val cafeName: String
)