package io.freddie.usersvc.controller

import com.netflix.discovery.EurekaClient
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/eureka-sample")
class EurekaSampleController(
    private val eurekaClient: EurekaClient,
    private val loadBalanceWebClient: WebClient.Builder,
    private val discoveryClient: DiscoveryClient
) {
    @GetMapping("/service")
    fun getServiceUrl(serviceName: String): String {
        val instance = eurekaClient.getNextServerFromEureka(serviceName, false)
        return "${instance.hostName}:${instance.port}"
    }

    /**
     * 이렇게 직접 호출할 수 있지만, 실제로는 Feign을 이용하는게 더 좋음
     */
    @GetMapping("/cafe-proxy")
    fun getCafes(): Mono<String> {
        val instance = eurekaClient.getNextServerFromEureka("cafe", false)
        val webClient = WebClient.create()
        return webClient.get()
            .uri {
                it.host(instance.hostName)
                    .port(instance.port)
                    .path("/api/cafes")
                    .build()
            }
            .retrieve()
            .bodyToMono(String::class.java)
    }

    @GetMapping("/cafe-proxy-lb")
    fun getCafesWithLb(): Mono<String> {
        return loadBalanceWebClient.build().get()
            .uri("http://cafe/api/cafes")
            .retrieve()
            .bodyToMono(String::class.java)
    }
}