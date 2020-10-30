<%@ page import="com.asaas.utils.Utils" %>

<div class="modal fade" id="edit-bill-modal" tabindex="-1" role="dialog" aria-labelledby="edit-bill-modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="<g:createLink controller='bill' action='update'/>" method="POST">
                <div class="modal-header">
                    <h5 class="modal-title" id="edit-bill-modalLabel">EDITAR</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" style="padding: 20px">
                    <input type="hidden" value="${bill.id}" name="id">

                    <div class="form-group">
                        <label for="value">Valor</label>
                        <input type="text" data-input-type="text" value="${bill.value}" name="value" class="form-control" id="value" maxlength="10" data-constraint="money">
                    </div>
                    <div class="form-group">
                        <label for="value">Vencimento em</label><br>
                        <input name="dueDate" type="date" value="${Utils.fromDate(bill.dueDate)}">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Atualizar</button>
                </div>
            </form>
        </div>
    </div>
</div>
