package com.fw.template.code.service;

import com.fw.template.code.dto.CodeDetailDto;
import com.fw.template.code.dto.CodeDto;
import com.fw.template.code.entity.CodeDetailEntity;
import com.fw.template.code.entity.CodeEntity;
import com.fw.template.code.repository.CodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CodeService {

    private final CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public CodeDto getList() {
        List<CodeEntity> list = codeRepository.findAll();
        ModelMapper mapper = new ModelMapper();
        return mapper.map(list, CodeDto.class);
    }

    public CodeDto getListByQuerydsl() {
        List<CodeEntity> list = codeRepository.getListByQuerydsl();
        ModelMapper mapper = new ModelMapper();
        return mapper.map(list, CodeDto.class);
    }

    public CodeDetailDto testJpql() {
        List<CodeDetailEntity> list = codeRepository.testJpql();
        ModelMapper mapper = new ModelMapper();
        return mapper.map(list, CodeDetailDto.class);
    }

    public Optional<CodeEntity> getOne(String id) {
        return codeRepository.findById(id);
    }


    public CodeDto getDetailListByQuerydsl() {
        List<CodeDetailEntity> list = codeRepository.getDetailListByQuerydsl();
        ModelMapper mapper = new ModelMapper();
        return mapper.map(list, CodeDto.class);
    }

    public CodeEntity addCode(CodeEntity newCode) {
        String id = newCode.getCode();

        return codeRepository.findById(id)
                .map(code -> {
                    log.info("이미 있는 코드");
                    return code;
                })
                .orElseGet(() -> {
                    log.info("신규 코드");
                    newCode.setCode(id);
                    return codeRepository.save(newCode);
                });
    }

    public void deleteCode(CodeEntity delCode) {
        codeRepository.delete(delCode);
    }
}
