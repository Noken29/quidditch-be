package com.noken.quidditchbe;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@OpenAPIDefinition
public class QuidditchBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuidditchBeApplication.class, args);
    }

}
