package com.cf.study.distribute.system.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cf.study.distribute.system.bean.Calculate24;

@RestController
public class Calculate24Controller {

    @CrossOrigin
    @GetMapping("/calculate24/{a}/{b}/{c}/{d}")
    public String calculate(@PathVariable final int a, @PathVariable final int b, @PathVariable final int c, @PathVariable final int d) {
        return Calculate24.calculate(a, b, c, d);
    }

}
