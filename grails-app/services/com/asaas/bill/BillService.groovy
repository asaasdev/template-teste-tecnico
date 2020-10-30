package com.asaas.bill

import com.asaas.customer.Customer
import com.asaas.enums.bill.BillStatus
import com.asaas.utils.Utils

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import groovy.transform.TypeCheckingMode

@Transactional
@GrailsCompileStatic
class BillService {

    public Bill save(Customer customer, BigDecimal value, Date dueDate) {
        Bill validatedBill = validateSave(dueDate)
        if (validatedBill.hasErrors()) return validatedBill

        Bill bill = new Bill()
        bill.customer = customer
        bill.value = value
        bill.dueDate = dueDate
        bill.status = BillStatus.PENDING
        bill.save(failOnError: true)
        return bill
    }

    @GrailsCompileStatic(TypeCheckingMode.SKIP)
    private Bill validateSave(Date dueDate) {
        Bill validateBill = new Bill()

        if (dueDate.clone().clearTime() < new Date().clearTime()) {
            Utils.addError(validateBill, "bill.error.invalidDueDate")
            return validateBill
        }

        return validateBill
    }

    public Bill update(Bill bill, BigDecimal value, Date dueDate) {
        bill.value = value
        bill.dueDate = dueDate
        bill.save(failOnError: true)
        return bill
    }

    public Bill delete(Bill bill) {
        bill.delete(failOnError: true)
        return bill
    }
}
