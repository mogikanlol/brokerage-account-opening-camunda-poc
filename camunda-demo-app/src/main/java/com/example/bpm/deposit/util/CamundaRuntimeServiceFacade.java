package com.example.bpm.deposit.util;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class CamundaRuntimeServiceFacade {

    private final RuntimeService runtimeService;

    /**
     * Starts process instance
     *
     * @param processName name of the process
     * @param variables   map of the variables which will be put in the process context
     * @param businessKey businessKey that will be bound to the process
     */
    public void startProcess(String processName, Map<String, Object> variables, String businessKey) {
        runtimeService.createProcessInstanceByKey(processName)
                .setVariables(variables)
                .businessKey(businessKey)
                .execute();
    }

    /**
     * Create message correlation by businessKey. BusinessKey should be unique for each process instances
     *
     * @param messageName the name of the message event
     * @param businessKey the businessKey to correlate on
     * @param varName     the variable's name
     * @param value       the value of the variable
     */
    public void createMessageCorrelation(String messageName, String businessKey, String varName, Object value) {
        createMessageCorrelation(messageName, businessKey, Collections.singletonMap(varName, value));
    }

    /**
     * Create message correlation by businessKey. BusinessKey should be unique for each process instances
     *
     * @param messageName the name of the message event
     * @param businessKey the businessKey to correlate on
     * @param variables   the map of the variables which will be put in the process
     */
    public void createMessageCorrelation(String messageName, String businessKey, Map<String, Object> variables) {
        runtimeService.createMessageCorrelation(messageName)
                .processInstanceBusinessKey(businessKey)
                .setVariables(variables)
                .correlateWithResult();
    }

}
