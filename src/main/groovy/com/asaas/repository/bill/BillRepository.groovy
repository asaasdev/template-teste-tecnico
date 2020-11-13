package com.asaas.repository.bill

import com.asaas.bill.Bill
import grails.gorm.DetachedCriteria

class BillRepository {

    public static DetachedCriteria<Bill> query(Map search) {
        DetachedCriteria<Bill> query = Bill.where {

            if (search.containsKey("customer")) {
                eq("customer", search.customer)
            }

            if (search.containsKey("customerName[like]")) {
                like("customer.name", "%" + search."customerName[like]" + "%")
            }

            if (search.containsKey("value")) {
                eq("value", search.value)
            }

            if (search.containsKey("dueDate")) {
                eq("dueDate", search.dueDate)
            }

            if (search.containsKey("dueDate")) {
                eq("dueDate", search.dueDate)
            }

            if (search.containsKey("status")) {
                eq("status", search.status)
            }

            order(search.sort ?: "id", search.order ?: "desc")
        }

        return query
    }
}