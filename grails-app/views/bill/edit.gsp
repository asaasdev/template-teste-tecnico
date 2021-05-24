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
                    <label for="typeBilling">Forma de pagamento</label><br>
                    <select id="typeBilling" class="form-control" name="typeBilling" required>
                        <option value="">Selecione uma opção</option>
                        <option value="Boleto Bancário" ${bill.typeBilling == 'Boleto Bancário' ? 'selected' : ''}>Boleto Bancário</option>
                        <option value="Cartão de Crédito" ${bill.typeBilling == 'Cartão de Crédito' ? 'selected' : ''}>Cartão de Crédito</option>
                        <option value="Transferência Bancária" ${bill.typeBilling == 'Transferência Bancária' ? 'selected' : ''}>Transferência Bancária</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="paymentDate">Pagamento em </label><br>
                    <input id="paymentDate" value="${params.paymentDate}" name="paymentDate" type="date" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Atualizar</button>
            </form>
        </div>
    </body>
</html>

