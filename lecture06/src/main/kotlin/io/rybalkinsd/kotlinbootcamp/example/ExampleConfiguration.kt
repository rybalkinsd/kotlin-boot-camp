package io.rybalkinsd.kotlinbootcamp.example

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.web.context.WebApplicationContext

@Configuration
class ExampleConfiguration {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    fun singletonBean(): SingletonBean {
        return SingletonBean("This is singleton bean")
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun prototypeBean(): PrototypeBean {
        return PrototypeBean("This is prototype bean")
    }

    @Bean
    @Scope(WebApplicationContext.SCOPE_REQUEST)
    fun requestBean(): RequestBean {
        return RequestBean("This is request bean")
    }
}