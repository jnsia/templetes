package com.jnsia.elasticsearch.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration

@Configuration
class ElasticsearchConfig(
    @Value("\${spring.elasticsearch.username}")
    private val username: String,

    @Value("\${spring.elasticsearch.password}")
    private val password: String,

    @Value("\${spring.elasticsearch.host}")
    private val host: String
): ElasticsearchConfiguration() {
    override fun clientConfiguration(): ClientConfiguration {
        return ClientConfiguration.builder()
                .connectedTo(host)
                .withBasicAuth(username, password)
                .build();
    }
}