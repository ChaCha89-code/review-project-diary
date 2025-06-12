package com.github.chacha89.reviewprojectdiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReviewProjectDiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewProjectDiaryApplication.class, args);
    }

}
