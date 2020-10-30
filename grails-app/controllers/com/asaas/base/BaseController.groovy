package com.asaas.base

import com.asaas.enums.message.MessageType

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

    protected buildAjaxResponse (Boolean success, String mainMessage, entity) {
        def response = ['success': success]

        MessageType type = success ? MessageType.SUCCESS : MessageType.ERROR

        String subMessage = mainMessage

        if (!subMessage && entity?.hasErrors() && entity.errors.allErrors[0].codes[0]) {
            subMessage = message(code: entity.errors.allErrors[0].defaultMessage ?: entity.errors.allErrors[0].codes[0])
        }

        response.put('messageHtml', g.render(template: "/utils/message/message", model: ['type': type, 'message': mainMessage, 'entity': entity]))
        response += [message: [type: type.toString().toLowerCase(), text: subMessage]]
        return response
    }
}
