<g:if test="${flash.message}">
    <div class="alert alert-${flash.type} alert-dismissible fade show" role="alert">
        <strong>${flash.message}</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</g:if>