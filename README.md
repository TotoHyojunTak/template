# SpringBoot 기반 Template Framework

# Spec
- SpringBoot 2.7.2
- JDK 17
- Dependency
``` 
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'com.querydsl:querydsl-jpa'
    implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.8.0'
    implementation 'org.apache.commons:commons-lang3:3.12.0'
    implementation 'org.modelmapper:modelmapper:3.1.0'
    implementation 'io.springfox:springfox-boot-starter:3.0.0'
    implementation 'io.springfox:springfox-swagger2:3.0.0'
    implementation 'io.springfox:springfox-swagger-ui:3.0.0'
    compileOnly 'org.projectlombok:lombok'
    runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
```

# Done
- swagger 설정 (ver 3.0.0)
- QueryDsl 설정

# TODO
- 게시물 API
  - 등록
  - 조회
  - 수정
  - 삭제
  - 페이징 API (customer class 설정)
- 댓글 API
  - 등록 
  - 조회 
  - 수정 
  - 삭제
  - 페이징 API (customer class 설정)
- Intellij 에서 DB 연결
- Exception 공통 처리
- Bean Validation 처리


# Swagger 3.x 이상 버전에서 실행하는 방법
- http://localhost:8080/swagger-ui/index.html
