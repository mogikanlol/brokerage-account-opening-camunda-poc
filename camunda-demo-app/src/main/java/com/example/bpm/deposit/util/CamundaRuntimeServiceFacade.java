package com.example.bpm.deposit.util;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Component;

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

}
