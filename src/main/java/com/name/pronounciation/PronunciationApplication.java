package com.name.pronounciation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PronunciationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PronunciationApplication.class, args);
    }

}
