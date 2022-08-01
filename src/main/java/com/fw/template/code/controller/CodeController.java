package com.fw.template.code.controller;

import com.fw.template.code.dto.CodeDetailDto;
import com.fw.template.code.dto.CodeDto;
import com.fw.template.code.entity.CodeEntity;
import com.fw.template.code.service.CodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/code")
@Api(value="CodeController Swagger", tags = "CodeController")
@RestController
@Slf4j
public class CodeController {

    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/testJpql")
    @ApiOperation(value = "list")
    public CodeDetailDto testJpql() {
        return codeService.testJpql();
    }

    /*
        1개 Table JPA
     */
    @GetMapping("/getList")
    @ApiOperation(value = "list")
    public CodeDto getList() {
        return codeService.getList();
    }

    /*
        1개 Table QueryDSl
     */
    @GetMapping("/getListByQuerydsl")
    @ApiOperation(value = "list")
    public CodeDto getListByQuerydsl() {
        return codeService.getListByQuerydsl();
    }

    /*
        2Join W/t QueryDSl
     */
    @GetMapping("/getDetailListByQuerydsl")
    @ApiOperation(value = "list")
    public CodeDto getDetailListByQuerydsl() {
        return codeService.getDetailListByQuerydsl();
    }

    /*
        1개 Table JPA
     */
    @GetMapping("/getOne/{id}")
    @ApiOperation(value = "list")
    public Optional<CodeEntity> getOne(@PathVariable String id) {
        // model-mapper 설정
        return codeService.getOne(id);
    }

    @PostMapping("/codes/{id}")
    public CodeEntity addCode(@RequestBody CodeEntity newCode, @PathVariable String id){
        log.info("id : {}", id);

        newCode.setCode(id);

        return codeService.addCode(newCode);
    }

    @DeleteMapping("/codes/{id}")
    public void deleteCode(@PathVariable String id) {

        CodeEntity delCode = null;
        delCode.setCode(id);

        codeService.deleteCode(delCode);
    }
}
