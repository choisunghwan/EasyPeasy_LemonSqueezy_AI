package com.EasyPeasy.AiProject.domain.service_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class service_01_Controller {


    @GetMapping("/service_01")
    public String showService_01Page() {
        return "user/pattern/service_01/service_01-detail";
    }
}
