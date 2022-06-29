package org.github.mlb.content.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jihongyuan
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"org.github.mlb.content.biz.api"})
public class MlbContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MlbContentApplication.class, args);
    }


}
