package com.fw.template.code.entity;

import com.fw.template.code.dto.CodeDto;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@ToString(of = {"code", "codeNm"})
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name="TB_CODE")
public class CodeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "codeNm", nullable = false)
    private String codeNm;


    private String description;

    @Embedded
    private BasicEntity basicEntity;

    @OneToMany(mappedBy="code")
    private List<CodeDetailEntity> codeDetail = new ArrayList<CodeDetailEntity>();


    public static CodeEntity of (CodeDto code){
        CodeEntity entity = new CodeEntity();
        entity.code = code.getCode();
        entity.codeNm = code.getCodeNm();
        return entity;
    }
}
