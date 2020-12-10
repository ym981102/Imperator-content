package org.starrier.imperator.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Starrier
 * @date 2019/4/28
 */
@EnableAsync
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class ImperatorContent {

    public static void main(String[] args) {
        SpringApplication.run(ImperatorContent.class, args);
    }

}
