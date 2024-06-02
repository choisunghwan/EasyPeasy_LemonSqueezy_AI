package com.EasyPeasy.AiProject.domain.fire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class fireController {


    @GetMapping("/fire_list")
    public String showFireDetectLogPage(){


        return "user/pattern/fire/fire-list";
    }
}
