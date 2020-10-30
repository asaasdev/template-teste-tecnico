package com.asaas.base

import grails.gorm.dirty.checking.DirtyCheck

@DirtyCheck
abstract class BaseEntity {

    Date lastUpdated

    Date dateCreated

    Boolean deleted = false

    static mapping = {
        tablePerHierarchy false
    }

    static constraints = {
        lastUpdated nullable: true
        dateCreated    nullable: true
        deleted nullable: true
    }
}