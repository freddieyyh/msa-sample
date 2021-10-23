package io.freddie.usersvc.controller

import mu.KLogging
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserController {
    @GetMapping
    fun getUsers(request: ServerHttpRequest, response: ServerHttpResponse): Mono<String> {
        val headers = request.headers.map { entry -> "${entry.key} : ${entry.value}" }
            .joinToString("\n")

        logger.info { "User Request called" }
        return Mono.fromRunnable<String?> {
            logger.info { headers }
        }.thenReturn("User Content")
    }

    companion object : KLogging()
}