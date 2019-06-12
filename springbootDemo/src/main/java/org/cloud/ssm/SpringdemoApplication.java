package org.cloud.ssm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdemoApplication  {

    private final static Logger logger = LoggerFactory.getLogger("o.c.y.Main");

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class, args);
        logger.info("============= SpringBoot Start Success =============");
    }
}
