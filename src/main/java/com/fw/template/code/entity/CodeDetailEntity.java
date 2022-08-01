package com.fw.template.code.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString(of = {"code", "detail_code", "detail_code_nm"})
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name="TB_CODE_DETAIL")
public class CodeDetailEntity {


    @NotNull
    @Id
    @Column(name = "detail_code", nullable = false)
    private String detail_code;

    @NotNull
    @Column(name = "detail_code_nm", nullable = false)
    private String detail_code_nm;

    private String description;

    @Embedded
    private BasicEntity basicEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="code", referencedColumnName = "code")
    private CodeEntity code;


}
