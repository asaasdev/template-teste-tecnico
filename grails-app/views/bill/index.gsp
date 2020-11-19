<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title><g:message code="app.tittle"/></title>
</head>
<body>

<a class="btn btn-primary" style="margin: 20px" href="<g:createLink controller='bill' action='create'/>">Criar cobrança</a>

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
                <th>Cliente</th>
                <th>Valor</th>
                <th>Vencimento</th>
                <th>Situação</th>
                <th>Formas de Pagamentos</th>
                <th>Data de Pagamento</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="bill" in="${billList}">
                <tr>
                    <td><a href="<g:createLink controller='bill' action='show' id='${bill.id}'/>">${bill.customer.name}</a></td>
                    <td>R$ <g:formatNumber number="${bill.value}" type="number" maxFractionDigits="2" minFractionDigits="2"/></td>
                    <td><g:formatDate date="${bill.dueDate}" format="dd/MM/yyyy" /></td>
                    <td><g:message code="BillStatus.${bill.status}"/></td>
                    <td>${bill.formOfPayment}</td>
                     <td><g:formatDate date="${bill.paymentDate}" format="dd/MM/yyyy" /></td>
                </tr>
            </g:each>
            </tbody>
        </table>

        <g:if test="${billList.size() < billList.totalCount}">
            <div class="pagination">
                <g:paginate total="${billList.totalCount}" action="index" maxsteps="5" params="${params}" next="Próximo" prev="Anterior"/>
            </div>
        </g:if>
    </g:if>
    <g:else>
        <div class="alert alert-dark" role="alert">
            Você ainda não possui cobranças.
        </div>
    </g:else>
</div>

</body>
</html>
