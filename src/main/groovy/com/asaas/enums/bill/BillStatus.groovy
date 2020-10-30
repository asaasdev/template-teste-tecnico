package com.asaas.enums.bill

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
enum BillStatus {
    PENDING,
    OVERDUE,
    RECEIVED

    public Boolean isReceived() {
        return [BillStatus.RECEIVED].contains(this)
    }
}