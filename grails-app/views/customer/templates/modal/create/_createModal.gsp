<div class="modal fade" id="create-customer-modal" tabindex="-1" role="dialog" aria-labelledby="create-customer-modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="<g:createLink controller='customer' action='save'/>" method="POST">
                <div class="modal-header">
                    <h5 class="modal-title" id="create-customer-modalLabel">CADASTRAR CLIENTE</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" style="padding: 20px">
                    <div class="form-group">
                        <label for="name"><strong>Nome</strong></label>
                        <input type="text" name="name" class="form-control" id="name">
                    </div>
                    <div class="form-group">
                        <label for="email"><strong>E-mail</strong></label>
                        <input type="text" name="email" class="form-control" id="email">
                    </div>
                    <div class="form-group">
                        <label for="mobilePhone"><strong>Celular</strong></label>
                        <input type="text" name="mobilePhone" class="form-control" id="mobilePhone">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </div>
            </form>
        </div>
    </div>
</div>
