package com.bdcourse.deliveryProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BdCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdCourseApplication.class, args);
    }

}
