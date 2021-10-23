package io.freddie.gateway.filter

import mu.KLogging
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class GlobalFilter : AbstractGatewayFilterFactory<GlobalConfig>(GlobalConfig::class.java) {
    override fun apply(config: GlobalConfig): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            logger.info { "base logger ${config.baseMessage} " }
            if (config.preLogger) {
                logger.info { "Pre global filter ${exchange.request} " }
            }
            chain.filter(exchange).then(Mono.fromRunnable {
                if (config.postLogger) {
                    logger.info { "Post global filter ${exchange.response} " }
                }
            })
        }
    }

    companion object : KLogging() {

    }
}

data class GlobalConfig(
    val baseMessage: String,
    val preLogger: Boolean,
    val postLogger: Boolean
)