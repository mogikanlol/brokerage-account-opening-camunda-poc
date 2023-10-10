package com.example.bpm.brokerage.account.opening.delegate;

import com.example.bpm.brokerage.account.opening.constants.OpeningVariables;
import com.example.bpm.brokerage.account.opening.dto.message.OpeningRequestMessage;
import com.example.bpm.brokerage.account.opening.messaging.OpeningAgreementProducer;
import com.example.bpm.brokerage.account.util.DelegateExecutionWrapper;
import com.example.bpm.brokerage.account.util.JavaDelegateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SendOpeningRequestDelegate extends JavaDelegateWrapper {

    private final OpeningAgreementProducer producer;

    @Override
    public void execute(DelegateExecutionWrapper execution) {

        String tariffId = execution.getVariable(OpeningVariables.PROVIDER_TARIFF_ID);
        String correlationId = execution.getVariable(OpeningVariables.CORRELATION_ID);
        OpeningRequestMessage message = new OpeningRequestMessage()
                .setTariffId(tariffId)
                .setCorrelationId(correlationId);

        producer.sendOpeningRequest(message);
    }
}
