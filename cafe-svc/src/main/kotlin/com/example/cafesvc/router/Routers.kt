package com.example.cafesvc.router

import com.example.cafesvc.config.CafeConfig
import com.example.cafesvc.handler.CafeHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class Routers {
    @Bean
    fun cafeRouter(cafeHandler: CafeHandler, cafeConfig: CafeConfig) = router {
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                GET("/cafes/{name}", cafeHandler::getCafes)
            }
        }

        "/config".nest {
            GET("/name") {
                ServerResponse.ok().bodyValue(cafeConfig.cafeName)
            }
        }
    }
}