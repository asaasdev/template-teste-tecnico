<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Cobrança</title>
    </head>
    <body>
        <div id="show-customer" class="content scaffold-show" role="main">
            <g:if test="${flash.message}">
                <div class="alert alert-${flash.type} alert-dismissible fade show" role="alert">
                    <strong>${flash.message}</strong>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </g:if>

            <div>
                <div class="col-md-5">
                    <ol class="property-list">
                        <li class="fieldcontain">
                            <span class="property-label">
                                Identificador
                            </span>
                            <div class="property-value">
                                ${bill.id}
                            </div>
                        </li>
                        <li class="fieldcontain">
                            <span class="property-label">
                                Nome:
                            </span>
                            <div class="property-value">
                                <g:link controller="customer" action="show" id="${bill.customer.id}">
                                    ${bill.customer.name}
                                </g:link>
                            </div>
                        </li>
                        <li class="fieldcontain">
                            <span class="property-label">
                                Valor
                            </span>
                            <div class="property-value">
                                R$ <g:formatNumber number="${bill.value}"/>
                            </div>
                        </li>
                        <li class="fieldcontain">
                            <span class="property-label">
                                Vencimento:
                            </span>
                            <div class="property-value">
                                <g:formatDate date="${bill.dueDate}" format="dd/MM/yyyy" />
                            </div>
                        </li>
                        <li class="fieldcontain">
                            <form action="<g:createLink controller='bill' action='delete'/>" method="POST">
                                <input type="hidden" value="${bill.id}" name="id"/>
                                <button type="submit" class="btn btn-danger">
                                    Remover
                                </button>
                            </form>
                            <br>
                            <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#edit-bill-modal">
                                Editar
                            </button>
                        </li>
                    </ol>
                </div>
            </div>

            <g:render template="templates/modal/edit/editModal" model="[bill: bill]"/>

        </div>
    </body>
</html>
