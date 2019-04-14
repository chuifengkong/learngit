package com.springdemo.meetingreserve.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制模板页面的跳转
 */
@Controller
@RequestMapping("/th")
public class AllController {

    @RequestMapping("/login")
    public String login(){
        return "thymeleaf/login";
    }

}
