package com.asaas.bill

import com.asaas.customer.Customer
import com.asaas.enums.bill.BillStatus

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class BillService {

    public Bill save(Long customerId, BigDecimal value, Date dueDate) {
        Bill bill = new Bill()

        bill.customer = Customer.get(customerId)
        bill.value = value
        bill.dueDate = dueDate
        bill.save()

        return bill
    }

    public Bill update(Bill bill, BigDecimal value, Date dueDate) {
        bill.value = value
        bill.dueDate = dueDate
        bill.save()

        return bill
    }

    public Bill delete(Bill bill) {
        bill.delete()

        return bill
    }
}
