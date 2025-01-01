package com.jnsia.elasticsearch.service

import com.jnsia.elasticsearch.document.SignInLog
import com.jnsia.elasticsearch.repository.SignInLogRepository
import org.springframework.data.elasticsearch.core.SearchHits
import org.springframework.stereotype.Service
import java.time.ZonedDateTime
import java.util.UUID

@Service
class LogService(
    private val signInLogRepository: SignInLogRepository
) {
    fun signIn(username: String) {
        signInLogRepository.save(
            SignInLog(
                id = UUID.randomUUID(),
                time = ZonedDateTime.now(),
                username = username,
                ipAddress = "",
                userAgent = "",
            )
        )
    }

    fun getSignInLogsByUsername(username: String): List<SignInLog> {
        return signInLogRepository.findAllByUsername(username)
    }
}