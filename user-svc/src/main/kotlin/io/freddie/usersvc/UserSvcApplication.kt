package io.freddie.usersvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import reactivefeign.spring.config.EnableReactiveFeignClients

@EnableDiscoveryClient
@EnableFeignClients
@EnableReactiveFeignClients
@SpringBootApplication
class UserSvcApplication

fun main(args: Array<String>) {
    runApplication<UserSvcApplication>(*args)
}
