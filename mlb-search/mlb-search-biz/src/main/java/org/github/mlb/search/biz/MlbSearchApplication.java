package org.github.mlb.search.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MlbSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MlbSearchApplication.class, args);
    }

}
