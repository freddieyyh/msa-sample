package io.freddie.msaexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsaExampleApplication

fun main(args: Array<String>) {
    runApplication<MsaExampleApplication>(*args)
}
