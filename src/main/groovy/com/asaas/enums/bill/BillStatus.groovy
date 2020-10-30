package com.asaas.enums.bill

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
enum BillStatus {
    PENDING,
    OVERDUE,
    PAID

    public Boolean isPaid() {
        return [BillStatus.PAID].contains(this)
    }
}