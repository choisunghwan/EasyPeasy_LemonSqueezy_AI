package com.EasyPeasy.AiProject.domain.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String ShowHomePage() {
        return "user/pattern/main_01";
    }
}


