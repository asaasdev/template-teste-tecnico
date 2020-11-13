package com.asaas.customer

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerServiceSpec extends Specification {

    CustomerService customerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Customer(...).save(flush: true, failOnError: true)
        //new Customer(...).save(flush: true, failOnError: true)
        //Customer customer = new Customer(...).save(flush: true, failOnError: true)
        //new Customer(...).save(flush: true, failOnError: true)
        //new Customer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customer.id
    }

    void "test get"() {
        setupData()

        expect:
        customerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Customer> customerList = customerService.list(max: 2, offset: 2)

        then:
        customerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerService.count() == 5
    }

    void "test delete"() {
        Long customerId = setupData()

        expect:
        customerService.count() == 5

        when:
        customerService.delete(customerId)
        sessionFactory.currentSession.flush()

        then:
        customerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Customer customer = new Customer()
        customerService.save(customer)

        then:
        customer.id != null
    }
}
