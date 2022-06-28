package org.github.mlb.dms;

import org.github.mlb.dms.client.BinlogClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;


@SpringBootApplication
@ConfigurationPropertiesScan
public class MlbDmsApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext run = SpringApplication.run(MlbDmsApplication.class, args);
        BinlogClient client = run.getBean(BinlogClient.class);
        client.start();
    }

}
