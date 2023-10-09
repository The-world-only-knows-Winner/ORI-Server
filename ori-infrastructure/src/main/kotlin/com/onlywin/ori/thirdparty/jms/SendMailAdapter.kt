package com.onlywin.ori.thirdparty.jms

import com.onlywin.ori.common.annotation.Adapter
import com.onlywin.ori.common.spi.SendMailPort
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender

@Adapter
class SendMailAdapter(
    private val javaMailSender: JavaMailSender,
    @Value("\${spring.mail.username}")
    private val oriEmail: String,
) : SendMailPort {

    override fun sendMail(title: String, content: String, email: String) {
        val message = SimpleMailMessage().apply {
            setTo(email)
            from = oriEmail
            subject = title
            text = content
        }

        javaMailSender.send(message)
    }
}
