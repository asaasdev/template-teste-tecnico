<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title><g:message code="app.tittle"/></title>
    </head>
    <body>
        <div id="create-bill" class="content scaffold-create" role="main">
            <g:if test="${flash.message}">
                <div class="alert alert-${flash.type} alert-dismissible fade show" role="alert">
                    <strong>${flash.message}</strong>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </g:if>

            <form action="<g:createLink controller='bill' action='save'/>" method="POST" style="width: 300px; padding: 30px">
                <div class="form-group">
                    <label for="customerId">Cliente</label><br>
                    <g:select id="customerId" value="${params.customerId}" name="customerId" class="form-control" noSelection="${[0: 'Selecione um cliente']}" from="${availableCustomerList}" optionKey="id" optionValue="name"/>
                </div>
                <div class="form-group">
                    <label for="value">Valor</label>
                    <input required="required" step=".01" type="number" value="${params.value}" data-input-type="text" name="value" value="0.00" class="form-control" id="value" maxlength="10" data-constraint="money" style="text-align: right;">
                </div>
                <div class="form-group">
                    <label for="dueDate">Vencimento em</label><br>
                    <input id="dueDate" value="${params.dueDate}" name="dueDate" type="date" required="required" class="form-control">
                </div>
                <div class="form-group">
                    <label for="typeBilling">Forma de pagamento</label><br>
                    <select id="typeBilling" class="form-control" name="typeBilling" required>
                            <option value="">Selecione uma opção</option>
                            <option value="Boleto Bancário">Boleto Bancário</option>
                            <option value="Cartão de Crédito">Cartão de Crédito</option>
                            <option value="Transferência Bancária">Transferência Bancária</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="paymentDate">Pagamento em </label><br>
                    <input id="paymentDate" value="${params.paymentDate}" name="paymentDate" type="date" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Criar cobrança</button>
            </form>
        </div>
    </body>
</html>


