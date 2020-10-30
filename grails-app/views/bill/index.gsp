<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Cobranças</title>
    </head>
    <body>
        <button type="button" class="btn btn-primary" style="margin: 20px" data-toggle="modal" data-target="#create-bill-modal">
            Criar cobrança
        </button>

        <g:if test="${flash.message}">
            <div class="alert alert-${flash.type} alert-dismissible fade show" role="alert">
                <strong>${flash.message}</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </g:if>

        <div id="list-bill" class="content scaffold-list" role="main">
            <g:if test="${billList}">
                <table class="table">
                    <thead class="thead">
                        <tr>
                            <th>Identificador</th>
                            <th>Cliente</th>
                            <th>Valor</th>
                            <th>Vencimento</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each var="bill" in="${billList}">
                        <tr>
                            <td>${bill.id}</td>
                            <td>${bill.customer.name}</td>
                            <td>R$ <g:formatNumber number="${bill.value}"/></td>
                            <td><g:formatDate date="${bill.dueDate}" format="dd/MM/yyyy" /></td>
                            <td>
                                <button type="#" class="btn btn-default">
                                    <a href="<g:createLink controller='bill' action='show' id='${bill.id}'/>">Detalhes</a>
                                </button>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </g:if>
            <g:else>
                <div class="alert alert-dark" role="alert">
                    Você ainda não possui cobranças.
                </div>
            </g:else>
        </div>

        <g:render template="templates/modal/create/createModal" />
    </body>
</html>
