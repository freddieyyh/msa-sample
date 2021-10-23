package io.freddie.usersvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserSvcApplication

fun main(args: Array<String>) {
    runApplication<UserSvcApplication>(*args)
}
