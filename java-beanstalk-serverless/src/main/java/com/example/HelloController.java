package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final String lambdaUrl;

    public HelloController(@Value("${lambdaurl}") String lambdaUrl) {
        logger.info("lambdaUrl {}", lambdaUrl);
        logger.info("lambdaurl from System.env {}", System.getenv("lambdaurl"));
        this.lambdaUrl = lambdaUrl;
    }

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        logger.info("hello");
        return "Hello World!";
    }

    @RequestMapping("/params")
    @ResponseBody
    String params() {
        logger.info("params {}", lambdaUrl);
        logger.info("lambdaurl from System.env {}", System.getenv("lambdaurl"));
        return lambdaUrl;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
}