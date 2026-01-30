package com.example.LearningJava.component;

import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class EnterHolidayDelegate implements JavaDelegate {

    @Override
    public void execute(org.flowable.engine.delegate.DelegateExecution delegateExecution) {
        System.out.println("=== EnterHolidayDelegate executed ===");

        Integer holidayDays = (Integer) delegateExecution.getVariable("holidayDays");

        System.out.println("Number of holiday days requested: " + holidayDays);
    }
}
