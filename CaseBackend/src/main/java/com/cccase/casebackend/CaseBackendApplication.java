package com.cccase.casebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.cccase.casebackend.mapper")
@SpringBootApplication(scanBasePackages = "com.cccase")
@EnableTransactionManagement
public class CaseBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseBackendApplication.class, args);
    }

}
