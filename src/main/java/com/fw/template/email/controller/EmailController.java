package com.fw.template.email.controller;


import com.fw.template.email.dto.MailDto;
import com.fw.template.email.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmailController {
    private final MailService mailService;

    @PostMapping("/sendmail")
    public String send(@RequestBody MailDto dto) {
        mailService.sendMail(dto);
        return "success";
    }
}
