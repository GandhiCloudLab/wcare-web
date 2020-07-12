package com.gan.wcarewebservice.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Configuration
@CrossOrigin
@RestController
public class RootController {

    @RequestMapping("/")
    private ModelAndView welcome() {
        return new ModelAndView("login");
    }

    @GetMapping("/hello")
    private String hello() {
        String result = "Welcome to Wcare Web service ..." ;
        System.out.println(result);
        return result;
    }
}
