<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title><g:message code="app.tittle"/></title>
</head>
<body>
    <a class="btn btn-primary" style="margin: 20px" href="<g:createLink controller='customer' action='create'/>">Cadastrar cliente</a>

    <g:if test="${flash.message}">
        <div class="alert alert-${flash.type} alert-dismissible fade show" role="alert">
            <strong>${flash.message}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </g:if>

    <div id="list-customer" class="content scaffold-list" role="main">
        <g:if test="${customerList}">
            <table class="table">
                <thead class="thead">
                <tr>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Celular</th>
                    <th>CPF/CNPJ</th>
                </tr>
                </thead>
                <tbody>
                <g:each var="customer" in="${customerList}">
                    <tr>
                        <td><a href="<g:createLink controller='customer' action='show' id='${customer.id}'/>">${customer.name}</a></td>
                        <td>${customer.email}</td>
                        <td>${customer.mobilePhone}</td>
                        <td>${customer.cpfCnpj}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>

            <g:if test="${customerList.size() < customerList.totalCount}">
                <div class="pagination">
                    <g:paginate total="${customerList.totalCount}" action="index" maxsteps="5" params="${params}" next="Próximo" prev="Anterior"/>
                </div>
            </g:if>
        </g:if>
        <g:else>
            <div class="alert alert-dark" role="alert">
                Você ainda não possui clientes cadastrados.
            </div>
        </g:else>
    </div>
</body>
</html>
