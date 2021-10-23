package io.freddie.gateway.filter

import mu.KLogging
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class UserFilter : AbstractGatewayFilterFactory<UserConfig>(UserConfig::class.java) {
    override fun apply(config: UserConfig): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            logger.info { "base logger ${config.baseMessage} " }
            if (config.preLogger) {
                logger.info { "Pre user filter ${exchange.request} " }
            }
           chain.filter(exchange).then(Mono.fromRunnable {
               if (config.postLogger) {
                   logger.info { "Post user filter ${exchange.response} " }
               }
           })
        }
    }

    companion object : KLogging() {
    }
}

data class UserConfig(
    val baseMessage: String,
    val preLogger: Boolean,
    val postLogger: Boolean
)