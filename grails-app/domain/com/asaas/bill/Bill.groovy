package com.asaas.bill

import com.asaas.base.BaseEntity
import com.asaas.customer.Customer
import com.asaas.enums.bill.BillStatus

class Bill extends BaseEntity {

    Customer customer

    BigDecimal value

    Date dueDate

    String typeBilling

    BillStatus status = BillStatus.PENDING

    Date paymentDate

    static constraints = {
        typeBilling blank: false
        paymentDate nullable: true, blank: false

        value validator: { value, obj, errors ->
            if (value <= 0) errors.rejectValue("value", "min.exceeded")
        }

        dueDate validator: { dueDate, obj, errors ->
            if (!obj.id && dueDate.clone().clearTime() < new Date().clearTime()) errors.rejectValue("dueDate", "invalid")
        }
    }
    static mapping = {
        // the deleted property may be configured
        // like any other persistent property...
        deleted column:"delFlag"
    }
}
