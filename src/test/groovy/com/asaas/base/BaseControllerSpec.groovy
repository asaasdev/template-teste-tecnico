package com.asaas.base

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class BaseControllerSpec extends Specification implements ControllerUnitTest<BaseController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
