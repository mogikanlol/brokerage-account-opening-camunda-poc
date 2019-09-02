package com.example.bpm.deposit.opening.delegate;

import com.example.bpm.deposit.opening.constants.OpeningVariables;
import com.example.bpm.deposit.opening.dto.message.DepositRequestMessage;
import com.example.bpm.deposit.opening.messaging.DepositAgreementProducer;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SendDepositRequestDelegate implements JavaDelegate {

    private final DepositAgreementProducer producer;

    @Override
    public void execute(DelegateExecution execution) {

        String depositId = (String) execution.getVariable(OpeningVariables.DEPOSIT_ID);
        DepositRequestMessage message = new DepositRequestMessage()
                .setDepositId(depositId);

        producer.sendDepositRequest(message);
    }
}
