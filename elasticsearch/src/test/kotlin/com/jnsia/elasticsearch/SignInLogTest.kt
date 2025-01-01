package com.jnsia.elasticsearch

import com.jnsia.elasticsearch.repository.SignInLogRepository
import com.jnsia.elasticsearch.service.LogService
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@SpringBootTest
class SignInLogTest @Autowired constructor(
    private val logService: LogService,
    private val signInLogRepository: SignInLogRepository
) {

    @BeforeEach
    fun setup() {
        signInLogRepository.deleteAll()
    }

    @Test
    fun `signIn should save SignInLog`() {
        // Given
        val username = "testUser"
        val count = 3

        // When
        for (i in 1..count) {
            logService.signIn(username);
        }

        // Then
        val logs = logService.getSignInLogsByUsername(username)
        assertTrue { logs.size == count }
        logs.map { assertEquals(username, it.username) }
    }
}