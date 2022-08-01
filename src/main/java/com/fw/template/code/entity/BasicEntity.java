package com.fw.template.code.entity;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class BasicEntity {
    private LocalDateTime regDtm;
    private String regId;
    private LocalDateTime modDtm;
    private String modId;
}
