package com.asaas.repository.customer

import com.asaas.customer.Customer

import grails.gorm.DetachedCriteria

class CustomerRepository {

    public static DetachedCriteria<Customer> query(Map search) {
        DetachedCriteria<Customer> query = Customer.where {

            if (!Boolean.valueOf(search.includeDeleted?.asBoolean())) {
                eq("deleted", false)
            }

            if (search.containsKey("column")) {
                projections {
                    property("${search.column}")
                }
            }

            if (search.containsKey("email")) {
                eq("email", search.email)
            }

            if (search.containsKey("name")) {
                eq("name", search.name)
            }

            if (search.containsKey("mobilePhone")) {
                eq("mobilePhone", search.mobilePhone)
            }

            if (search.containsKey("exists")) {
                projections {
                    property("id")
                }
            } else {
                order(search.sort ?: "id", search.order ?: "desc")
            }
        }

        return query
    }
}