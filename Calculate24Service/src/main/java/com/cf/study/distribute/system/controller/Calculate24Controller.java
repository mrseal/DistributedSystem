package com.cf.study.distribute.system.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cf.study.distribute.system.bean.Calculate24;

@RestController
public class Calculate24Controller {

    @CrossOrigin
    @RequestMapping("/")
    public String healthcheck() {
        return "Calculate24 Service";
    }

    @CrossOrigin
    @GetMapping("/{applicationName}")
    public String calculate(@RequestParam("a") final int a, @RequestParam("b") final int b, @RequestParam("c") final int c,
            @RequestParam("d") final int d) {
        return Calculate24.calculate(a, b, c, d);
    }

}
