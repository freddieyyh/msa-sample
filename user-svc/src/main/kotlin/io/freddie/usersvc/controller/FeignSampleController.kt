package io.freddie.usersvc.controller

import feign.codec.Decoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feign-sample")
class FeignSampleController(
    private val cafeDirectService: CafeDirectService,
    private val cafeRibbonService: CafeRibbonService
) {
    @GetMapping("/cafe-proxy")
    fun getCafes(
        @RequestParam name: String,
        @RequestParam(defaultValue = "direct") type: String
    ): String {
        return when (type) {
            "direct" -> cafeDirectService.getCafe(name)
            "ribbon" -> cafeRibbonService.getCafe(name)
            else -> throw NotImplementedError()
        }
    }
}

@Configuration
class FeignConfiguration() {
    @Bean
    fun feignDecoder() : Decoder {
        val factory = ObjectFactory<HttpMessageConverters> {
            HttpMessageConverters()
        }

        return SpringDecoder(factory)
    }
}

@FeignClient(name = "cafe-direct", url = "\${cafe.url}")
interface CafeDirectService {
    @GetMapping("/api/cafes/{name}", consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE])
    fun getCafe(@PathVariable name: String): String
}

@FeignClient("cafe")
interface CafeRibbonService {
    @GetMapping("/api/cafes/{name}", consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE])
    fun getCafe(@PathVariable name: String): String
}