package com.github.mlb.content.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.github.mlb.content.biz.api"})
@MapperScan(basePackages = {"com.github.mlb.content.biz.**.mapper"})
public class MlbContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MlbContentApplication.class, args);
    }

}
