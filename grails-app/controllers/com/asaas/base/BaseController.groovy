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
            if (useEntityError) flash.message = message(code: entity.errors.allErrors[0].codes[0] ?: entity.errors.allErrors[0].defaultMessage)
        }
    }

    protected Integer getLimitPerPage() {
        if (params.max == 'undefined') params.max = null

        Integer max = Math.min(Integer.valueOf(params.max ? params.max : Integer.valueOf(grailsApplication.config.getProperty("pagination.limit.default"))), Integer.valueOf(grailsApplication.config.getProperty("pagination.limit.max")))
        return max
    }

    protected Integer getCurrentPage() {
        if (params.offset == 'undefined') params.offset = null

        Integer offset = Integer.valueOf(params.offset ? params.offset : Integer.valueOf(grailsApplication.config.getProperty("pagination.offset.default")))
        return offset
    }
}
