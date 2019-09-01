package com.example.bpm.deposit.opening.delegate;

import com.example.bpm.deposit.opening.constants.OpeningVariables;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InitAgreementDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        String depositId = (String) execution.getVariable(OpeningVariables.DEPOSIT_ID);
        String correlationId = (String) execution.getVariable(OpeningVariables.CORRELATION_ID);

        log.info("Data for deposit opening was prepared");
        log.info("depositId = {}", depositId);
        log.info("correlationId = {}", correlationId);
    }
}
