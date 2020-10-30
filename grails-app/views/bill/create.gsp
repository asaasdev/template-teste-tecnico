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
                    <g:select id="customerId" value="${params.customerId}"  name="customerId" class="form-control" noSelection="${[0: 'Selecione um cliente']}" from="${availableCustomerList}" optionKey="id" optionValue="name"/>
                </div>
                <div class="form-group">
                    <label for="value">Valor</label>
                    <input type="text" value="${params.value}" data-input-type="text" name="value" value="0.00" class="form-control" id="value" maxlength="10" data-constraint="money" style="text-align: right;">
                </div>
                <div class="form-group">
                    <label for="dueDate">Vencimento em</label><br>
                    <input id="dueDate" value="${params.dueDate}" name="dueDate" type="date">
                </div>
                <button type="submit" class="btn btn-primary">Criar cobrança</button>
            </form>
        </div>
    </body>
</html>


