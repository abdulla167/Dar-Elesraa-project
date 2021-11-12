package com.medicalsheets.darelesraa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class DarElesraaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DarElesraaApplication.class, args);
        log.error("errrrrrrrrrrrrrrrrrrrrorr");
        log.debug("ok");
    }

}
