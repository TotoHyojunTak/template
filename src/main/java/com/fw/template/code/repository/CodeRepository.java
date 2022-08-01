package com.fw.template.code.repository;

import com.fw.template.code.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<CodeEntity, String>, CodeRepositoryCustom {

}
