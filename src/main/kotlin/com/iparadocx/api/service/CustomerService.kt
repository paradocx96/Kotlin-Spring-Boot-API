package com.iparadocx.api.service

import com.iparadocx.api.dto.CustomerRequest
import com.iparadocx.api.exception.NotFoundException
import com.iparadocx.api.model.Customer
import com.iparadocx.api.repository.RepositoryCustomer
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val repositoryCustomer: RepositoryCustomer
) {
    fun createCustomer(request: CustomerRequest): Customer =
        repositoryCustomer.save(
            Customer(
                name = request.name,
                address = request.address,
                email = request.email
            )
        )

    fun findAllCustomer(): List<Customer> =
        repositoryCustomer.findAll()

    fun findCustomerById(id: String): Customer =
        repositoryCustomer.findById(id)
            .orElseThrow {
                NotFoundException("Customer with id $id not found")
            }


    fun updateCustomer(id: String, request: CustomerRequest): Customer {
        val customer = findCustomerById(id)
        val updatedCustomer = repositoryCustomer.save(
            customer.apply {
                name = request.name
                address = request.address
                email = request.email
            }
        )
        return updatedCustomer
    }

    fun deleteCustomerById(id: String) {
        val customer = findCustomerById(id)
        repositoryCustomer.delete(customer)
    }
}