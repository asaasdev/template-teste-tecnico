package com.asaas.customer

import com.asaas.repository.customer.CustomerRepository
import com.asaas.utils.Utils

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class CustomerService {

    public Customer save(String name, String email, String mobilePhone) {
        Customer validatedCustomer = validateSave(name, email)
        if (validatedCustomer.hasErrors()) return validatedCustomer

        Customer customer = new Customer()
        customer.name = name
        customer.email = email
        customer.mobilePhone = mobilePhone
        customer.save(failOnError: true)

        return customer
    }

    private Customer validateSave(String name, String email) {
        Customer validateCustomer = new Customer()

        Boolean hasAnotherCustomerWithSameEmail = CustomerRepository.query([exists: true, email: email]).get()
        if (hasAnotherCustomerWithSameEmail) {
            Utils.addError(validateCustomer, "customer.error.emailInUse")
            return validateCustomer
        }

        if (!Utils.isValidEmail(email)) {
            Utils.addError(validateCustomer, "customer.error.invalidEmail")
            return validateCustomer
        }

        if (!name) {
            Utils.addError(validateCustomer, "customer.error.invalidName")
            return validateCustomer
        }

        return validateCustomer
    }

    public Customer update(Customer customer, String name, String email, String mobilePhone) {
        customer.name = name
        customer.email = email
        customer.mobilePhone = mobilePhone
        customer.save(failOnError: true)
        return customer
    }

    public Customer delete(Customer customer) {
        customer.delete(failOnError: true)
        return customer
    }
}
