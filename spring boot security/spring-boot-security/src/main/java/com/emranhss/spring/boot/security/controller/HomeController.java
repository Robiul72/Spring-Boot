package com.emranhss.spring.boot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class HomeController {

@RequestMapping("")
public String home(){

    return "home";

    }


    @RequestMapping("/viewpage")
    public String viewPage(){

        return "viewpage";

    }
}
