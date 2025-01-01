package com.jnsia.elasticsearch.document

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import org.springframework.data.elasticsearch.annotations.Setting
import java.time.ZonedDateTime
import java.util.UUID

// index == table of RDB
@Document(indexName = "sign_in_logs")
@Setting(replicas = 0)
data class SignInLog(
    @Id
    @Field(type = FieldType.Keyword)
    val id: UUID,

    @Field(type = FieldType.Keyword)
    val username: String,

    @Field(type = FieldType.Date, index = false)
    val time: ZonedDateTime?,

    @Field(type = FieldType.Text)
    val ipAddress: String,

    @Field(type = FieldType.Text)
    val userAgent: String?,
)