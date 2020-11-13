package com.asaas.bill

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BillServiceSpec extends Specification {

    BillService billService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Bill(...).save(flush: true, failOnError: true)
        //new Bill(...).save(flush: true, failOnError: true)
        //Bill bill = new Bill(...).save(flush: true, failOnError: true)
        //new Bill(...).save(flush: true, failOnError: true)
        //new Bill(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //bill.id
    }

    void "test get"() {
        setupData()

        expect:
        billService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Bill> billList = billService.list(max: 2, offset: 2)

        then:
        billList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        billService.count() == 5
    }

    void "test delete"() {
        Long billId = setupData()

        expect:
        billService.count() == 5

        when:
        billService.delete(billId)
        sessionFactory.currentSession.flush()

        then:
        billService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Bill bill = new Bill()
        billService.save(bill)

        then:
        bill.id != null
    }
}
