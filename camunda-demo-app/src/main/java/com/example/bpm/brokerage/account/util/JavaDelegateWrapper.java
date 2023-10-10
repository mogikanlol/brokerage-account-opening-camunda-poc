package com.example.bpm.brokerage.account.util;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public abstract class JavaDelegateWrapper implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execute(new DelegateExecutionWrapper(execution));
    }

    protected abstract void execute(DelegateExecutionWrapper executionWrapper);
}
