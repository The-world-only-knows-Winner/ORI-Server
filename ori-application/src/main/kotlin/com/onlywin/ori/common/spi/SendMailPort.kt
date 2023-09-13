package com.onlywin.ori.common.spi

interface SendMailPort {

    fun sendMail(title: String, content: String, email: String)
}
