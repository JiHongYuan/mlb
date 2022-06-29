package org.github.mlb.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jihongyuan
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.github.mlb")
@EnableFeignClients(basePackages = {"org.github.mlb.content.biz.api"})
public class MlbContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MlbContentApplication.class, args);
    }


}
