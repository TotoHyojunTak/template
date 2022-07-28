package com.fw.template.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.base.path}")
    private String basePath;

    @Bean
    public Docket api(TypeResolver typeResolver) {


        return new Docket(DocumentationType.SWAGGER_2)
                .alternateTypeRules(
                        AlternateTypeRules.newRule(typeResolver.resolve(Pageable.class), typeResolver.resolve(Page.class)))
                .select() // ApiSelectorBuilder를 생성
                .apis(RequestHandlerSelectors.basePackage(basePath))
                    // api 스펙이 작성되어 있는 패키지를 지정한다. 즉, 컨트롤러가 존재하는 패키지를 basepackage로 지정하여, RequestMapping( GetMapping, PostMapping ... )이 선언된 API를 문서화한다.
                .paths(PathSelectors.any()) //apis()로 선택된 부분 중 특정 path 조건에 맞는 API들을 다시 필터링하여 문서화
                .build()
                .apiInfo(apiInfo())
                        // 제목, 설명 등 문서에 대한 정보들을 보여주기 위해 호출한다.
                        // 파라미터 정보: public ApiInfo( title, description, version, termsOfServiceUrl, contact, license, licenseUrl, vendorExtensions )
                ;
    }

    @Getter
    @Setter
    @ApiModel
    static class Page {
        @ApiModelProperty(value = "페이지 번호(0..N)", example = "0")
        private Integer page;

        @ApiModelProperty(value = "페이지 크기", allowableValues="range[0, 100]", example = "10")
        private Integer size;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Template API")
                .description("Template API")
                .version("1.0")
                .build();
    }
}
