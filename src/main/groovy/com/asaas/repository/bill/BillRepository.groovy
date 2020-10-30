package com.asaas.repository.bill

import com.asaas.bill.Bill
import grails.gorm.DetachedCriteria

class BillRepository {

    public static DetachedCriteria<Bill> query(Map search) {
        DetachedCriteria<Bill> query = Bill.where {
            if (BillRepository.joinWithCustomer(search)) {
                createAlias("customer", "customer")
            }

            if (!Boolean.valueOf(search.includeDeleted?.asBoolean())) {
                eq("deleted", false)
            }

            if (search.containsKey("column")) {
                projections {
                    property("${search.column}")
                }
            }

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

    private static Boolean joinWithCustomer(Map search) {
        return (search.containsKey("customerName[like]"))
    }

}