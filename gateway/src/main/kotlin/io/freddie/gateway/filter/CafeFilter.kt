package io.freddie.gateway.filter

import mu.KLogging
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CafeFilter : AbstractGatewayFilterFactory<CafeConfig>(CafeConfig::class.java) {
    override fun apply(config: CafeConfig): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            logger.info { "base logger ${config.baseMessage} " }
            if (config.preLogger) {
                logger.info { "Pre cafe filter ${exchange.request} " }
            }
            chain.filter(exchange).then(Mono.fromRunnable {
                if (config.postLogger) {
                    logger.info { "Post cafe filter ${exchange.response} " }
                }
            })
        }
    }

    companion object : KLogging() {
    }
}

data class CafeConfig(
    val baseMessage: String,
    val preLogger: Boolean,
    val postLogger: Boolean
)