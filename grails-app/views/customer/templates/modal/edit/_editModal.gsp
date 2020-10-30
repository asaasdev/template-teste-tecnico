<div class="modal fade" id="edit-customer-modal" tabindex="-1" role="dialog" aria-labelledby="edit-customer-modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="<g:createLink controller='customer' action='update'/>" method="POST">
                <div class="modal-header">
                    <h5 class="modal-title" id="edit-customer-modalLabel">EDITAR</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" style="padding: 20px">
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
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Atualizar</button>
                </div>
            </form>
        </div>
    </div>
</div>
