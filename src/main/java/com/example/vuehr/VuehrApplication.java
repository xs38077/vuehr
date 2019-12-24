package com.example.vuehr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * branch: xs
 */
@SpringBootApplication
@EnableCaching
public class VuehrApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuehrApplication.class, args);
    }

}
