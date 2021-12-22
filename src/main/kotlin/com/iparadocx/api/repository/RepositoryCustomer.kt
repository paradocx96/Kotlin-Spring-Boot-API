package com.iparadocx.api.repository

import com.iparadocx.api.model.Customer
import org.springframework.data.mongodb.repository.MongoRepository

interface RepositoryCustomer : MongoRepository<Customer, String> {
}