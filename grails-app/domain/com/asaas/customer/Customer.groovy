package com.asaas.customer

import com.asaas.base.BaseEntity
import com.asaas.utils.Utils

class Customer extends BaseEntity {

    String email

    String name

    String mobilePhone

    String cpfCnpj

    static constraints = {
        mobilePhone nullable: true
        name blank: false
        email blank: false
        cpfCnpj blank: false


        email validator: { email, obj, errors ->
            if (!Utils.isValidEmail(email)) errors.rejectValue("email", "invalid")
        }
       
    }
    static mapping = {
        // the deleted property may be configured
        // like any other persistent property...
        deleted column:"delFlag"
    }
}
