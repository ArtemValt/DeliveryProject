package com.bdcourse.bdcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class BdCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdCourseApplication.class, args);
    }

}
