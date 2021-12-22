package com.iparadocx.api.dto

import com.iparadocx.api.model.Customer

class CustomerResponse(
    val id: String,
    val name: String,
    val address: String,
    var email: String
) {
    companion object {
        fun fromEntity(customer: Customer): CustomerResponse =
            CustomerResponse(
                id = customer.id!!,
                name = customer.name,
                address = customer.address,
                email = customer.email
            )
    }
}