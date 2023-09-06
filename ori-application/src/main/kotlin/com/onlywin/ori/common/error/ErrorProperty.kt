package com.onlywin.ori.common.error

interface ErrorProperty {

    val status: HttpStatus
    val message: String
}