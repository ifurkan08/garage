package com.kafein.garage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping("furkan")
    public ResponseEntity<String> getGo() {
        return ResponseEntity.ok("furkan");
    }

    @GetMapping("furkan2")
    public ResponseEntity<String> getGo2() {
        return ResponseEntity.ok("furkan2");
    }

    public ResponseEntity<String> furkan123(){
        return ResponseEntity.ok("furkan2");
    }
}
