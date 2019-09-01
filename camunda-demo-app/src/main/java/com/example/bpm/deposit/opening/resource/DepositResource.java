package com.example.bpm.deposit.opening.resource;

import com.example.bpm.deposit.opening.constants.OpeningVariables;
import com.example.bpm.deposit.opening.constants.ProcessName;
import com.example.bpm.deposit.opening.dto.DepositOpeningRequest;
import com.example.bpm.deposit.util.CamundaRuntimeServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/deposit/opening")
public class DepositResource {

    private final CamundaRuntimeServiceFacade runtimeServiceFacade;

    @PostMapping
    public void startOpening(@Valid @RequestBody DepositOpeningRequest request) {
        runtimeServiceFacade.startProcess(
                ProcessName.DEPOSIT_OPENING,
                createStartingVariables(request),
                request.getDepositId());
    }

    private Map<String, Object> createStartingVariables(DepositOpeningRequest request) {
        Map<String, Object> map = new HashMap<>();

        map.put(OpeningVariables.DEPOSIT_ID, request.getDepositId());
        map.put(OpeningVariables.CORRELATION_ID, request.getCorrelationId());
        map.put(OpeningVariables.INITIAL_MESSAGE, request);

        return map;
    }

}
