package com.example.baseballteammanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BaseballTeamManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseballTeamManagementApplication.class, args);
    }

}
