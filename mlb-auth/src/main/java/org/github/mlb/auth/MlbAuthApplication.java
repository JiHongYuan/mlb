package org.github.mlb.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @author jihongyuan
 */
@SpringBootApplication
@ConfigurationPropertiesScan
@ComponentScan(basePackages = "org.github.mlb")
@MapperScan(basePackages = {"org.github.mlb.auth.**.mapper"})
public class MlbAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MlbAuthApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
