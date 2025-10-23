package com.example.HealthClientServer.controller;

import com.example.HealthClientServer.model.HealthData;
import com.example.HealthClientServer.services.HealthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {

    private final HealthService adviceService;

    public HealthController(HealthService adviceService) {
        this.adviceService = adviceService;
    }

    @PostMapping("/data")
    public void collectHealthDataForAdvice(
            @RequestBody List<HealthData> userHealthData) {
        adviceService.generateHealthAdvices(userHealthData);
    }

}
