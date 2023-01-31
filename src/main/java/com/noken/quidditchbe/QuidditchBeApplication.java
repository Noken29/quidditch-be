package com.noken.quidditchbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class QuidditchBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuidditchBeApplication.class, args);
    }

}
