package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication

public class Main {

    private final static Logger LOGGER= LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        SpringApplication.run(Main.class);

    }
}