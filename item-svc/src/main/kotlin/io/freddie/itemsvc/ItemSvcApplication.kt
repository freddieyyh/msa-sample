package io.freddie.itemsvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ItemSvcApplication

fun main(args: Array<String>) {
    runApplication<ItemSvcApplication>(*args)
}
