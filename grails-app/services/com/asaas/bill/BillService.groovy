package com.asaas.bill

import com.asaas.customer.Customer
import com.asaas.enums.bill.BillStatus

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import java.text.DateFormat
import java.text.SimpleDateFormat

@Transactional
@GrailsCompileStatic
class BillService {

    public Bill save(Long customerId, BigDecimal value, Date dueDate, String typeBilling) {
        Bill bill = new Bill()

        bill.customer = Customer.get(customerId)
        bill.value = value
        bill.dueDate = dueDate
        bill.typeBilling = typeBilling
        bill.save()

        return bill
    }

    public Bill update(Bill bill, BigDecimal value, Date dueDate, String typeBilling) {
        bill.value = value
        bill.dueDate = dueDate
        bill.typeBilling = typeBilling
        bill.save()

        return bill
    }

    public Bill delete(Bill bill) {
        bill.delete()

        return bill
    }

}
