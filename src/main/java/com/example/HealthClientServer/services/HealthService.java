package com.example.HealthClientServer.services;

import com.example.HealthClientServer.model.HealthAdvice;
import com.example.HealthClientServer.model.HealthData;
import com.example.HealthClientServer.proxy.HealthProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {

    private final HealthProxy healthSystemProxy;

    public HealthService(HealthProxy healthSystemProxy) {
        this.healthSystemProxy = healthSystemProxy;
    }

    public void generateHealthAdvices(List<HealthData> userHealthData) {
        userHealthData.forEach(u -> {
            HealthAdvice advice = getMockHealthAdvice(u.getUsername());
            healthSystemProxy.sendAdvice(List.of(advice));
        });
    }

    private HealthAdvice getMockHealthAdvice(String username) {
        HealthAdvice advice = new HealthAdvice();
        advice.setUsername(username);
        advice.setAdvice("Mock advice for " + username);
        return advice;
    }

}
