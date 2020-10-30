package com.asaas.customer

import com.asaas.base.BaseController
import com.asaas.logger.Logger
import com.asaas.repository.customer.CustomerRepository

class CustomerController extends BaseController {

    CustomerService customerService

    def index() {
        List<Customer> customerList = CustomerRepository.query(params).list()
        return [customerList: customerList]
    }

    def show() {
        respond Customer.get(params.id)
    }

    def create() {
        return [:]
    }

    def save() {
        try {
            Customer customer = customerService.save(params.name, params.email, params.mobilePhone)
            if (!customer.hasErrors()) {
                buildResponse(true, "Cliente cadastrado com sucesso!", customer)
                redirect(action: "show", id: customer.id)
                return
            }
            buildResponse(false, null, customer)
        } catch (Exception exception) {
            Logger.error("CustomerController -> Exception ao salvar customer.", exception)
            buildResponse(false, null, null)
        }

        redirect(action: "create", params: params)
    }

    def edit() {
        respond Customer.get(params.id)
    }

    def update() {
        try {
            Customer customer = customerService.update(Customer.get(params.id), params.name, params.email, params.mobilePhone)
            if (!customer.hasErrors()) {
                buildResponse(true, "Os dados de seu cliente foram atualizados com sucesso!", customer)
                redirect(action: "show", id: customer.id)
                return
            }
            buildResponse(false, null, customer)
        } catch (Exception exception) {
            Logger.error("CustomerController -> Exception ao atualizar dados do customer.", exception)
            buildResponse(false, null, null)
        }

        redirect(action: "edit", id: params.id)
    }

    def delete() {
        try {
            Customer customer = customerService.delete(Customer.get(params.id))
            if (!customer.hasErrors()) {
                buildResponse(true, "Os dados de seu cliente foram atualizados com sucesso!", customer)
                redirect(action: "index")
                return
            }

            buildResponse(false, null, customer)
        } catch (Exception exception) {
            Logger.error("CustomerController -> Exception ao remover customer.", exception)
            buildResponse(false, null, null)
        }

        redirect(action: "show", id: params.id)
    }
}
