package com.cf.study.distributed.system;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GameService {

    RestTemplate restTemplate;

    public GameService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String calculate24(final int a, final int b, final int c, final int d) {
        return restTemplate.getForObject("http://calculate24/calculate24?a={a}&b={b}&c={c}&d={d}", String.class, a, b, c, d);
    }

    public String reliable(final int a, final int b, final int c, final int d) {
        return "Service not available! Try to get the answer from google.";
    }

}
