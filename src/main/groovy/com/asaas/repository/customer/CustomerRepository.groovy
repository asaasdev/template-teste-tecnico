package com.asaas.repository.customer

import com.asaas.customer.Customer

import grails.gorm.DetachedCriteria

class CustomerRepository {

    public static DetachedCriteria<Customer> query(Map search) {
        DetachedCriteria<Customer> query = Customer.where {

            if (search.containsKey("email")) {
                eq("email", search.email)
            }

            if (search.containsKey("name")) {
                eq("name", search.name)
            }

            if (search.containsKey("mobilePhone")) {
                eq("mobilePhone", search.mobilePhone)
            }

            order(search.sort ?: "id", search.order ?: "desc")
        }

        return query
    }
}