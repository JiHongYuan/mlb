package com.github.mlb.content;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.mlb.content.biz.mapper")
public class MlbContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MlbContentApplication.class, args);
    }

}
