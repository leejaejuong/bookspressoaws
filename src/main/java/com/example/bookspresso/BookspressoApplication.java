package com.example.bookspresso;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableBatchProcessing
public class BookspressoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookspressoApplication.class, args);
    }

}
