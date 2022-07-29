package com.rsakin.passengeranalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PassengerAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassengerAnalyzerApplication.class, args);
    }

}
