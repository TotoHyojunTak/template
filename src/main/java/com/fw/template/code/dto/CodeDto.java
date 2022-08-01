package com.fw.template.code.dto;

import com.fw.template.code.entity.CodeEntity;
import com.fw.template.common.AppUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter
public class CodeDto {

    public CodeDto(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "codeNm", nullable = false)
    private String codeNm;

    @Column(name = "description", nullable = false)
    private String description;

    private LocalDateTime regDtm;
    private String regId;
    private LocalDateTime modDtm;
    private String modId;

    public static CodeDto of(CodeEntity codeEntity
    ) {
        return AppUtil.getMapper().map(codeEntity, CodeDto.class);
    }
}
