package com.fw.template.code.repository;

import com.fw.template.code.entity.CodeDetailEntity;
import com.fw.template.code.entity.CodeEntity;

import java.util.List;

public interface CodeRepositoryCustom {
    List<CodeEntity> getListByQuerydsl();

    List<CodeDetailEntity> getDetailListByQuerydsl();

    List<CodeDetailEntity> testJpql();

}
