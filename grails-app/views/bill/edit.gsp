<!DOCTYPE html>
<%@ page import="com.asaas.utils.Utils" %>

<html>
    <head>
        <meta name="layout" content="main" />
        <title><g:message code="app.tittle"/></title>
    </head>
    <body>
        <div>
            <g:if test="${flash.message}">
                <div class="alert alert-${flash.type} alert-dismissible fade show" role="alert">
                    <strong>${flash.message}</strong>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </g:if>

            <form action="<g:createLink controller='bill' action='update'/>" method="POST" style="width: 300px; padding: 30px">
                <input type="hidden" value="${bill.id}" name="id">

                <div class="form-group">
                    <span class="property-label">
                        Identificador: ${bill.id}
                    </span>
                </div>
                <div class="form-group">
                    <span class="property-label">
                        Nome:
                        <g:link controller="customer" action="show" id="${bill.customer.id}">
                            ${bill.customer.name}
                        </g:link>
                    </span>
                </div>

                <div class="form-group">
                    <label for="value">Valor</label>
                    <input type="text" data-input-type="text" value="${bill.value}" name="value" class="form-control" id="value" maxlength="10" data-constraint="money" required="required" style="text-align: right;">
                </div>
                <div class="form-group">
                    <label for="value">Vencimento em</label><br>
                    <input name="dueDate" type="date" value="${Utils.fromDate(bill.dueDate)}" required="required" class="form-control">
                </div>
              
                 <div class="form-group">
                    <label for="formOfPayment">Forma de Pagamento</label><br>
                     
                        <select id="formOfPayment" name="formOfPayment" required="required" class="form-control">
                            <option></option>
                            <option value="Boleto Bancário">Boleto Bancário</option> 
                            <option value="Cartão de Crédito" >Cartão de Crédito</option>
                            <option value="Transferência Bancária">Transferência Bancária</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="value">Data de Pagamento</label><br>
                    <input name="paymentDate" type="date" value="${Utils.fromDate(bill.paymentDate)}" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Atualizar</button>
            </form>
        </div>
    </body>
</html>

