package com.example.cafesvc.handler

import mu.KLogging
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class CafeHandler {
    fun getCafes(request: ServerRequest) : Mono<ServerResponse> {
        logger.info { "Call get cafes" }

        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue("${request.pathVariable("name")} Cafe Contents")
    }

    companion object : KLogging()
}