package com.example.LearningJava.component;

import org.flowable.engine.delegate.JavaDelegate;

public class SendRejectionEmailDelegate implements JavaDelegate {
    @Override
    public void execute(org.flowable.engine.delegate.DelegateExecution delegateExecution) {
        System.out.println("=== SendRejectionEmailDelegate executed ===");
    }
}
