package com.EasyPeasy.AiProject.domain.login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String showLoginPage() {
        return "user/pattern/login";
    }
}
