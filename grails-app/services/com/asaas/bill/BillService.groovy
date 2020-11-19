package com.asaas.bill

import com.asaas.customer.Customer
import com.asaas.enums.bill.BillStatus

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class BillService {

    public Bill save(Long customerId, BigDecimal value, Date dueDate, String formOfPayment, Date paymentDate) {
        Bill bill = new Bill()
        bill.customer = Customer.get(customerId)
        bill.value = value
        bill.dueDate = dueDate
        bill.formOfPayment = formOfPayment
        bill.paymentDate = paymentDate
        if (bill.paymentDate != null){
            bill.status = BillStatus.PAID
        } 

        bill.save(flush: true)

        return bill
    }

    public Bill update(Bill bill, BigDecimal value, Date dueDate, String formOfPayment, Date paymentDate) {
        bill.value = value
        bill.dueDate = dueDate
        bill.formOfPayment = formOfPayment
        bill.paymentDate = paymentDate
        if (bill.paymentDate != null){
            bill.status = BillStatus.PAID
        } 
        bill.save()

        return bill
    }

    public Bill delete(Bill bill) {
        if (bill.status == BillStatus.PAID){
            return  bill
        }
        bill.delete(flush: true)

        return bill
    }
}
