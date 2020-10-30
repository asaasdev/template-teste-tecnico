<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title><g:message code="app.tittle"/></title>
    </head>
    <body>
        <g:if test="${flash.message}">
            <div class="alert alert-${flash.type} alert-dismissible fade show" role="alert">
                <strong>${flash.message}</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </g:if>

        <form action="<g:createLink controller='customer' action='update'/>" method="POST" style="width: 300px; padding: 30px">
            <input type="hidden" value="${customer.id}" name="id">

            <div class="form-group">
                <label for="name"><strong>Nome</strong></label>
                <input type="text" name="name" class="form-control" value="${customer.name}" id="name">
            </div>
            <div class="form-group">
                <label for="email"><strong>E-mail</strong></label>
                <input type="text" name="email" class="form-control" value="${customer.email}" id="email">
            </div>
            <div class="form-group">
                <label for="mobilePhone"><strong>Celular</strong></label>
                <input type="text" name="mobilePhone" class="form-control" value="${customer.mobilePhone}" id="mobilePhone">
            </div>

            <button type="submit" class="btn btn-primary">Atualizar</button>
        </form>
    </body>
</html>
