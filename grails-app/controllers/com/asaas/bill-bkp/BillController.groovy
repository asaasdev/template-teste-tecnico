package com.asaas.bill

import com.asaas.base.BaseController
import com.asaas.customer.Customer
import com.asaas.logger.Logger
import com.asaas.repository.bill.BillRepository
import com.asaas.repository.customer.CustomerRepository
import com.asaas.utils.Utils

class BillController extends BaseController {

    BillService billService

    def index() {
        List<Bill> billList = BillRepository.query(params).list()
        List<Customer> availableCustomerList = CustomerRepository.query(params).list()

        return [billList: billList, availableCustomerList: availableCustomerList]
    }

    def show() {
        return [bill: Bill.get(params.id)]
    }

    def save() {
        try {
            Bill bill = billService.save(params.customerId.toLong(), Utils.toBigDecimal(params.value), Utils.toDate(params.dueDate))
            if (!bill.hasErrors()) {
                buildResponse(true, "Cobrança criada com sucesso!", bill)
                redirect(action: "show", id: bill.id)
                return
            }

            buildResponse(false, null, bill)
        } catch (Exception exception) {
            Logger.error("CustomerController -> Exception ao salvar bill.", exception)
            buildResponse(false, null, null)
        }

        redirect(action: "index")
    }

    def delete() {
        try {
            Bill bill = billService.delete(Bill.get(params.id))

            if (bill.hasErrors()) {
                buildResponse(false, null, bill)
            } else {
                buildResponse(true, "Cobrança removida com sucesso.", bill)
            }
        } catch (Exception exception) {
            Logger.error("CustomerController -> Exception ao remover bill.", exception)
            buildResponse(false, null, null)
        }

        redirect(action: "index")
    }

    def update() {
        try {
            Bill bill = billService.update(Bill.get(params.id), Utils.toBigDecimal(params.value), Utils.toDate(params.dueDate))
            if (!bill.hasErrors()) {
                buildResponse(true, "Cobrança atualizada com sucesso!", bill)
                redirect(action: "show", id: bill.id)
                return
            }

            buildResponse(false, null, bill)
        } catch (Exception exception) {
            Logger.error("CustomerController -> Exception ao atualizar bill.", exception)
            buildResponse(false, null, null)
        }

        redirect(action: "index")
    }

}
