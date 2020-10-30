package com.asaas.base

class BaseController {

    protected void buildResponse(Boolean success, String messageDescription, entity) {
        flash.message = messageDescription

        if (success) {
            flash.type = "success"
        } else {
            flash.type = "danger"
            if (messageDescription) return

            flash.message = message(code: "unknown.error")
            Boolean useEntityError = (entity?.hasErrors() && entity.errors.allErrors[0].codes[0])
            if (useEntityError) flash.message = message(code: entity.errors.allErrors[0].defaultMessage ?: entity.errors.allErrors[0].codes[0])
        }
    }
}
