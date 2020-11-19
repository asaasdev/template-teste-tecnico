<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title><g:message code="app.tittle"/></title>
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
                            Identificador:
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
                            Valor:
                        </span>
                        <div class="property-value">
                            R$ <g:formatNumber number="${bill.value}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
                        </div>
                    </li>
                    <li class="fieldcontain">
                        <span class="property-label">
                            Situação:
                        </span>
                        <div class="property-value">
                            <g:message code="BillStatus.${bill.status}"/>
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
                        <span class="property-label">
                            Formas de Pagamentos:
                        </span>
                        <div class="property-value">
                            ${bill.formOfPayment}
                        </div>
                    </li>
                    <li class="fieldcontain">
                        <span class="property-label">
                            Data de Pagamento:
                        </span>
                        <div class="property-value">
                            <g:formatDate date="${bill.paymentDate}" format="dd/MM/yyyy" />
                        </div>
                    </li>
                    <li class="fieldcontain">
                        <a class="btn btn-info" href="<g:createLink controller='bill' action='edit' id='${bill.id}'/>">Editar</a>
                        <a class="btn btn-danger" href="<g:createLink controller='bill' action='delete' id='${bill.id}'/>">Remover</a>
                    </li>
                </ol>
            </div>
        </div>
    </div>
</body>
</html>
