package com.cschool.marcinipiotrek.lolex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String getHomePage() {
        return "views/index";

    }
    @GetMapping("/login")
    public String getLoginPage() {
        return "views/login";
    }

}
