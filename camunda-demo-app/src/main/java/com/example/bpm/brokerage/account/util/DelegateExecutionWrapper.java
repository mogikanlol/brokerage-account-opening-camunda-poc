package com.example.bpm.brokerage.account.util;

import lombok.Getter;
import org.camunda.bpm.engine.delegate.DelegateExecution;

@Getter
public class DelegateExecutionWrapper {

    private final DelegateExecution origin;

    public DelegateExecutionWrapper(DelegateExecution execution) {
        this.origin = execution;
    }

    public <T> T getVariable(ProcessVariable<T> processVariable) {
        String s = processVariable.get();
        return (T) origin.getVariable(s);
    }

}