package io.freddie.itemsvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
//@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean::class)
@EnableJpaRepositories
class ItemSvcApplication {

}

fun main(args: Array<String>) {
    runApplication<ItemSvcApplication>(*args)
}
