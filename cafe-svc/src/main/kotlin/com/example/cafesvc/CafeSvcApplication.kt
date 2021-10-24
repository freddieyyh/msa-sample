package com.example.cafesvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class CafeSvcApplication

fun main(args: Array<String>) {
    runApplication<CafeSvcApplication>(*args)
}
