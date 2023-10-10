package com.example.bpm.brokerage.account.opening.delegate;

import com.example.bpm.brokerage.account.opening.constants.OpeningVariables;
import com.example.bpm.brokerage.account.util.DelegateExecutionWrapper;
import com.example.bpm.brokerage.account.util.JavaDelegateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InitAgreementDelegate extends JavaDelegateWrapper {

    @Override
    public void execute(DelegateExecutionWrapper execution) {
        String tariffId = execution.getVariable(OpeningVariables.PROVIDER_TARIFF_ID);
        String correlationId = execution.getVariable(OpeningVariables.CORRELATION_ID);

        log.info("Data for account opening was prepared");
        log.info("tariffId = {}", tariffId);
        log.info("correlationId = {}", correlationId);
    }
}
