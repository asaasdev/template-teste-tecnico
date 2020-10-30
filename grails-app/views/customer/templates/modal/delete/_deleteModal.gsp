<div class="modal fade" id="delete-customer-modal" tabindex="-1" role="dialog" aria-labelledby="delete-customerLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="<g:createLink controller='customer' action='delete'/>" method="POST">
                <input type="hidden" value="${customer.id}" name="id"/>

                <div class="modal-header">
                    <h5 class="modal-title" id="delete-customerLabel">REMOVER CLIENTE</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Você tem certeza que deseja remover este cliente?<br>
                    Não será possível criar novas cobraças para este cliente.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">Cancelar</button>
                    <button type="submit" class="btn btn-danger">Remover</button>
                </div>
            </form>
        </div>
    </div>
</div>