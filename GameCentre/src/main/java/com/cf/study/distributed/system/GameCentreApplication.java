package com.cf.study.distributed.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class GameCentreApplication {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GameService gameService;

    @RequestMapping("/calculate24")
    public String calculate24(@RequestParam("a") final int a, @RequestParam("b") final int b, @RequestParam("c") final int c,
            @RequestParam("d") final int d) {
        return gameService.calculate24(a, b, c, d);
    }

    public static void main(final String[] args) {
        SpringApplication.run(GameCentreApplication.class, args);
    }
}
