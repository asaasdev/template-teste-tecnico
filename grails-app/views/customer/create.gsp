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

            <form action="<g:createLink controller='customer' action='save'/>" method="POST" style="width: 300px; padding: 30px">
                <div class="form-group">
                    <label for="name"><strong>Nome</strong></label>
                    <input type="text" name="name" class="form-control" value="${params.name}" id="name">
                </div>
                <div class="form-group">
                    <label for="email"><strong>E-mail</strong></label>
                    <input type="text" name="email" class="form-control" value="${params.email}" id="email">
                </div>
                <div class="form-group">
                    <label for="mobilePhone"><strong>Celular</strong></label>
                    <input type="text" name="mobilePhone" class="form-control" value="${params.mobilePhone}" id="mobilePhone">
                </div>

                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
    </body>
</html>
