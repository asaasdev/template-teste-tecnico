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
                        Identificador
                    </span>
                    <div class="property-value">
                        ${bill.id}
                    </div>
                </div>
                <div class="form-group">
                    <span class="property-label">
                        Nome:
                    </span>
                    <div class="property-value">
                        ${bill.customer.name}
                    </div>
                </div>

                <div class="form-group">
                    <label for="value">Valor</label>
                    <input type="text" data-input-type="text" value="${bill.value}" name="value" class="form-control" id="value" maxlength="10" data-constraint="money">
                </div>
                <div class="form-group">
                    <label for="value">Vencimento em</label><br>
                    <input name="dueDate" type="date" value="${Utils.fromDate(bill.dueDate)}">
                </div>
                <button type="submit" class="btn btn-primary">Atualizar</button>
            </form>
        </div>
    </body>
</html>

