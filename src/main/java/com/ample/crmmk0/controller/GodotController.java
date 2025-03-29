package com.ample.crmmk0.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8123") // 来自 Godot 的端口
public class GodotController {
    @PostMapping("/receive")
    public ResponseEntity<Map<String, String>> receiveData(@RequestBody Map<String, String> data) {
        String message = data.get("message");
        return ResponseEntity.ok(Map.of("response", "SV:客户端发送的消息: " + message));

    }
}
