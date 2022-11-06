package com.bankingexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = { "com.bankingexample", "com.bankingexample.controller" , "com.bankingexample.configuration"})
public class BankingExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingExampleApplication.class, args);
    }

}
