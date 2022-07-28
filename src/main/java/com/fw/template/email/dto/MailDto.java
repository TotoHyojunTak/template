package com.fw.template.email.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MailDto {
    private String title;
    private String text;
    private String receiver;
    private String sender;
}