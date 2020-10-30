package com.asaas.customer

import com.asaas.repository.customer.CustomerRepository
import com.asaas.utils.Utils

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class CustomerService {

    public Customer save(String name, String email, String mobilePhone) {
        Customer validatedCustomer = validateEmail(email)
        if (validatedCustomer.hasErrors()) return validatedCustomer

        Customer customer = new Customer()
        customer.name = name
        customer.email = email
        customer.mobilePhone = mobilePhone
        customer.save()

        return customer
    }

    private Customer validateEmail(String email) {
        Customer validateCustomer = new Customer()

        Boolean existsAnotherCustomerWithSameEmail = CustomerRepository.query([exists: true, email: email]).get()
        if (existsAnotherCustomerWithSameEmail) {
            Utils.addError(validateCustomer, "customer.error.emailInUse")
        }

        return validateCustomer
    }

    public Customer update(Customer customer, String name, String email, String mobilePhone) {
        customer.name = name
        customer.email = email
        customer.mobilePhone = mobilePhone
        customer.save()
        return customer
    }

    public Customer delete(Customer customer) {
        customer.delete()
        return customer
    }
}
