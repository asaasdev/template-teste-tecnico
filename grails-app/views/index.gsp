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
                    <a target="_blank" href="${g.createLink(controller: 'customer', action: 'index')}">
                        Clientes
                    </a>
                </li>
                <li class="list-group-item">
                    <a target="_blank" href="${g.createLink(controller: 'bill', action: 'index')}">
                        Cobranças
                    </a>
                </li>
            </div>
        </div>
    </body>
</html>
