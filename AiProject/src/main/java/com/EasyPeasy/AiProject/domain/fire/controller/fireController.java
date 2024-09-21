package com.EasyPeasy.AiProject.domain.fire.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class fireController {

    @GetMapping("/fire_list")
    public String showFireDetectLogPage(){

        return "user/pattern/fire/fire-list";

    }

    @PostMapping("/fire-alert")
    public ResponseEntity<String> fireAlert(@RequestBody Map<String, Object> payload) {
        Boolean fireDetected = (Boolean) payload.get("fire_detected");
        if (fireDetected != null && fireDetected) {
            // 로직: 예를 들어 데이터베이스에 저장 또는 알림 발송
            System.out.println("Fire detected! Alert received.");
            return ResponseEntity.ok("Alert received");
        } else {
            return ResponseEntity.badRequest().body("Invalid data");
        }
    }
}
