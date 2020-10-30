package com.asaas.customer

import com.asaas.base.BaseEntity
import com.asaas.utils.Utils

class Customer extends BaseEntity {

    String email

    String name

    String mobilePhone

    static constraints = {
        mobilePhone nullable: true
        name blank: false
        email blank: false

        email validator: { email, obj, errors ->
            if (!Utils.isValidEmail(email)) errors.rejectValue("email", "invalid")
        }
    }
}
