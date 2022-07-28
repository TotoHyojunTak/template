package com.fw.template.email.service;

import com.fw.template.email.dto.MailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailService {
    private final JavaMailSender javaMailSender;

    public void sendMail(MailDto dto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(dto.getReceiver());
            message.setFrom(dto.getSender());
            message.setText(dto.getText());
            message.setSubject(dto.getTitle());
            javaMailSender.send(message);
        } catch (MailParseException e) {
            e.printStackTrace();
        } catch (MailAuthenticationException e) {
            e.printStackTrace();
        } catch (MailSendException e) {
            e.printStackTrace();
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}