<div class="modal fade" id="create-bill-modal" tabindex="-1" role="dialog" aria-labelledby="create-bill-modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="<g:createLink controller='bill' action='save'/>" method="POST">
                <div class="modal-header">
                    <h5 class="modal-title" id="create-bill-modalLabel">NOVA COBRANÇA</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" style="padding: 20px">
                    <div class="form-group">
                        <label for="name">Cliente</label><br>
                        <g:select name="customerId" class="form-control" noSelection="${['': 'Selecione um cliente']}" from="${availableCustomerList}" optionKey="id" optionValue="name"/>
                    </div>
                    <div class="form-group">
                        <label for="value">Valor</label>
                        <input type="text" data-input-type="text" name="value" class="form-control" id="value" maxlength="10" data-constraint="money">
                    </div>
                    <div class="form-group">
                        <label for="value">Vencimento em</label><br>
                        <input name="dueDate" type="date">
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Criar cobrança</button>
                </div>
            </form>
        </div>
    </div>
</div>
