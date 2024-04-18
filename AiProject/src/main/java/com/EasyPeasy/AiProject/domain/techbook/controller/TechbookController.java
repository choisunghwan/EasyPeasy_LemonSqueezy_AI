package com.EasyPeasy.AiProject.domain.techbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechbookController {

    @GetMapping("/techbook_create")
    public String showTechbookCreatePage() {
        return "user/pattern/techbook/techbook-create";
    }
}
