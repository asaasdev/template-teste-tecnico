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
                            Nome:
                        </span>
                        <div class="property-value">
                            ${customer.name}
                        </div>
                    </li>
                    <li class="fieldcontain">
                        <span class="property-label">
                            E-mail:
                        </span>
                        <div class="property-value">
                            ${customer.email}
                        </div>
                    </li>
                    <li class="fieldcontain">
                        <span class="property-label">
                            Celular:
                        </span>
                        <div class="property-value">
                            ${customer.mobilePhone}
                        </div>
                    </li>
                    <li class="fieldcontain">
                        <a class="btn btn-info" href="<g:createLink controller='customer' action='edit' id='${customer.id}'/>">Editar</a>
                        <a class="btn btn-danger" href="<g:createLink controller='customer' action='delete' id='${customer.id}'/>">Remover</a>
                    </li>
                </ol>
            </div>
        </div>
    </div>
</body>
</html>
