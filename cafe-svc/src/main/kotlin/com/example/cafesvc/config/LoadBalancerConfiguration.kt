package com.example.cafesvc.config

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class LoadBalancerConfiguration {
    @Bean
    @LoadBalanced
    fun loadBalanceWebClient(): WebClient.Builder {
        return WebClient.builder()
    }
}