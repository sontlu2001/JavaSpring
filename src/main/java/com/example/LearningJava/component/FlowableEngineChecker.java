package com.example.LearningJava.component;

import jakarta.annotation.PostConstruct;
import org.flowable.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlowableEngineChecker {
    @Autowired
    private ProcessEngine processEngine;

    @PostConstruct
    public void check() {
        System.out.println("ProcessEngine name = " + processEngine.getName());
    }
}
