package com.example.cafesvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CafeSvcApplication

fun main(args: Array<String>) {
    runApplication<CafeSvcApplication>(*args)
}
