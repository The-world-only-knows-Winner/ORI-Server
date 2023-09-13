package com.onlywin.ori.thirdparty.jms

import com.onlywin.ori.common.annotation.Adapter
import com.onlywin.ori.common.spi.SendMailPort
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender

@Adapter
class SendMailAdapter(
    private val javaMailSender: JavaMailSender
) : SendMailPort {

    override fun sendMail(title: String, content: String, email: String) {
        val message = SimpleMailMessage().apply {
            setTo(email)
            subject = title
            text = content
        }

        javaMailSender.send(message)
    }
}