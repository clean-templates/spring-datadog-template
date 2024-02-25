package com.rolandsall.spring.datadog.template.api;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/test")
public class DummyController {


    @GetMapping("/api1")
    @Timed(value = "test-api", description = "description of test-api")
    public ResponseEntity<String> test() throws InterruptedException {
        Thread.sleep((new Random().nextInt(5) + 1) * 1000);
        return ResponseEntity.ok("Success");
    }
}
