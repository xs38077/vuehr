package com.example.vuehr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * branch: master v0.7    ----merge 合并分支处理
 */
@SpringBootApplication
@EnableCaching
public class VuehrApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuehrApplication.class, args);
    }

}
