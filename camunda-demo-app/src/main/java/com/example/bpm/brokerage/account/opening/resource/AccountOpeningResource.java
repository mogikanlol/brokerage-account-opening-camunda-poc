package com.example.bpm.brokerage.account.opening.resource;

import com.example.bpm.brokerage.account.opening.constants.OpeningVariables;
import com.example.bpm.brokerage.account.opening.constants.ProcessName;
import com.example.bpm.brokerage.account.opening.dto.AccountOpeningRequest;
import com.example.bpm.brokerage.account.util.CamundaRuntimeServiceFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account/opening")
public class AccountOpeningResource {

    private final CamundaRuntimeServiceFacade runtimeServiceFacade;

    @PostMapping
    public void startOpening(@Valid @RequestBody AccountOpeningRequest request) {
        runtimeServiceFacade.startProcess(
                ProcessName.BROKERAGE_ACCOUNT_OPENING,
                createStartingVariables(request),
                request.getCorrelationId()
        );
    }

    private Map<String, Object> createStartingVariables(AccountOpeningRequest request) {
        Map<String, Object> map = new HashMap<>();

        map.put(OpeningVariables.PROVIDER_TARIFF_ID.get(), request.getTariffId());
        map.put(OpeningVariables.CORRELATION_ID.get(), request.getCorrelationId());
        map.put(OpeningVariables.INITIAL_MESSAGE.get(), request);

        return map;
    }

}
