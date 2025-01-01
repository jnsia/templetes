package com.jnsia.elasticsearch.repository

import com.jnsia.elasticsearch.document.SignInLog
import org.springframework.data.elasticsearch.core.SearchHits
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface SignInLogRepository: ElasticsearchRepository<SignInLog, Long> {
    fun findAllByUsername(username: String): List<SignInLog>
}