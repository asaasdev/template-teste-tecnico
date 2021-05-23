package com.asaas.bill

import com.asaas.base.BaseController
import com.asaas.customer.Customer
import com.asaas.logger.Logger
import com.asaas.repository.bill.BillRepository
import com.asaas.repository.customer.CustomerRepository
import com.asaas.utils.Utils
import grails.gorm.PagedResultList

class BillController extends BaseController {

    BillService billService

    def index() {
        PagedResultList<Bill> billList = BillRepository.query(params).list(max: getLimitPerPage(), offset: getCurrentPage())
        return [billList: billList]
    }

    def show() {
        respond Bill.get(params.id)
    }

    def create() {
        List<Customer> availableCustomerList = CustomerRepository.query(params).list()
        return [availableCustomerList: availableCustomerList]
    }

    def save() {
        try {
            Bill bill = billService.save(params.customerId.toLong(), Utils.toBigDecimal(params.value), Utils.toDate(params.dueDate), params.typeBilling)
            if (!bill.hasErrors()) {
                buildResponse(true, "Cobrança criada com sucesso!", bill)
                redirect(action: "index")
                return
            }

            buildResponse(false, null, bill)
        } catch (Exception exception) {
            Logger.error("CustomerController -> Exception ao salvar bill.", exception)
            buildResponse(false, null, null)
        }

        redirect(action: "create", params: params)
    }

    def edit() {
        respond Bill.get(params.id)
    }

    def update() {
        try {
            Bill bill = billService.update(Bill.get(params.id), Utils.toBigDecimal(params.value), Utils.toDate(params.dueDate), params.typeBilling)
            if (!bill.hasErrors()) {
                buildResponse(true, "Cobrança atualizada com sucesso!", bill)
                redirect(action: "index")
                return
            }

            buildResponse(false, null, bill)
        } catch (Exception exception) {
            Logger.error("CustomerController -> Exception ao atualizar bill.", exception)
            buildResponse(false, null, null)
        }

        redirect(action: "edit", id: params.id)
    }

    def delete() {
        try {
            Bill bill = billService.delete(Bill.get(params.id))
            if (!bill.hasErrors()) {
                buildResponse(true, "Cobrança removida com sucesso.", bill)
                redirect(action: "index")
                return
            }
            buildResponse(false, null, bill)
        } catch (Exception exception) {
            Logger.error("CustomerController -> Exception ao remover bill.", exception)
            buildResponse(false, null, null)
        }

        redirect(action: "show", id: params.id)
    }
}
