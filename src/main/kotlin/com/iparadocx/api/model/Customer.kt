package com.iparadocx.api.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Customer (
    @Id
    val id: String? = null,
    var name: String,
    var address: String,
    var email: String
)