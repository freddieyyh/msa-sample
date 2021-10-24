package com.example.cafesvc.router

import com.example.cafesvc.handler.CafeHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
class Routers {
    @Bean
    fun cafeRouter(cafeHandler: CafeHandler) = router {
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                GET("/cafes/{name}", cafeHandler::getCafes)
            }
        }
    }
}