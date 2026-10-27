package com.Duocuc.Dockerfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DockerfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerfileApplication.class, args);
    }
}

@RestController
class HelloController {
    @GetMapping("/")
    public String index() {
        return "¡Microservicio DevOps funcionando al 100%!";
    }
}