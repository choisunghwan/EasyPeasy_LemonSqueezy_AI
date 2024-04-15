package com.EasyPeasy.AiProject.admin.service_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class service_01_adm_Controller {


    @GetMapping("/service_01_adm")
    public String showService_01_adm() {
        return "admin/pattern/service_01/service_01-create";
    }
}
