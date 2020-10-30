package com.asaas.customer

import com.asaas.base.BaseEntity

class Customer extends BaseEntity {

    String email

    String name

    String mobilePhone

    static constraints = {
        mobilePhone nullable: true
    }
}
