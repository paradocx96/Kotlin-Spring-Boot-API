package com.iparadocx.api.controller

import com.iparadocx.api.dto.CustomerRequest
import com.iparadocx.api.dto.CustomerResponse
import com.iparadocx.api.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customer")
class ControllerCustomer(
    private val customerService: CustomerService
) {
    @PostMapping
    fun create(@RequestBody request: CustomerRequest): ResponseEntity<CustomerResponse> {
        val createCustomer = customerService.createCustomer(request)
        return ResponseEntity
            .ok(
                CustomerResponse.fromEntity(createCustomer)
            )
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<CustomerResponse>> {
        val customers = customerService.findAllCustomer()
        return ResponseEntity
            .ok(
                customers.map {
                    CustomerResponse.fromEntity(it)
                }
            )
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<CustomerResponse> {
        val customer = customerService.findCustomerById(id)
        return ResponseEntity
            .ok(
                CustomerResponse.fromEntity(customer)
            )
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: String, @RequestBody request: CustomerRequest):
            ResponseEntity<CustomerResponse> {
        val customer = customerService.updateCustomer(id, request)
        return ResponseEntity
            .ok(
                CustomerResponse.fromEntity(customer)
            )
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: String): ResponseEntity<Void> {
        customerService.deleteCustomerById(id)
        return ResponseEntity.noContent().build()
    }
}