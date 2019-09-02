package com.example.bpm.deposit.opening.messaging;

import com.example.bpm.deposit.opening.constants.OpeningTopics;
import com.example.bpm.deposit.opening.constants.OpeningVariables;
import com.example.bpm.deposit.opening.dto.message.DepositConfirmationMessage;
import com.example.bpm.deposit.opening.dto.message.DepositRejectionMessage;
import com.example.bpm.deposit.util.CamundaRuntimeServiceFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DepositAgreementConsumer {

    private final CamundaRuntimeServiceFacade runtimeServiceFacade;

    @StreamListener(OpeningTopics.DEPOSIT_PROVIDER_CONFIRMATION)
    public void listenToDepositConfirmationMessage(DepositConfirmationMessage message) {
        log.info("Received DepositConfirmationMessage for depositId = {}", message.getDepositId());
        log.debug("Message = {}", message);

        runtimeServiceFacade.createMessageCorrelation(
                "depositAgreementResponseEvent",
                message.getDepositId(),
                OpeningVariables.DEPOSIT_REQUEST_CONFIRMED_BY_BANK,
                true);
    }

    @StreamListener(OpeningTopics.DEPOSIT_PROVIDER_REJECTION)
    public void listenToDepositRejectionMessage(DepositRejectionMessage message) {
        log.info("Received DepositRejectionMessage for depositId = {}", message.getDepositId());
        log.debug("Message = {}", message);

        runtimeServiceFacade.createMessageCorrelation(
                "depositAgreementResponseEvent",
                message.getDepositId(),
                OpeningVariables.DEPOSIT_REQUEST_CONFIRMED_BY_BANK,
                false);
    }
}
