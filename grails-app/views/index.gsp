<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Asaas</title>
    </head>

    <body>
        <div id="content" role="main">
            <div id="controllers" role="navigation">
                <li class="list-group-item">
                    <a href="${g.createLink(controller: 'customer', action: 'index')}">
                        Cadastro de Clientes
                    </a>
                </li>
                <li class="list-group-item">
                    <a href="${g.createLink(controller: 'bill', action: 'index')}">
                        Cadastro de Cobranças
                    </a>
                </li>
            </div>
        </div>
    </body>
</html>
