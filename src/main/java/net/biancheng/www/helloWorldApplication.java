package net.biancheng.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class helloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(helloWorldApplication.class, args);
    }
}
