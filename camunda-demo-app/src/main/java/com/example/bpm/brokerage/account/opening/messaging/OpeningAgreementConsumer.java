package com.example.bpm.brokerage.account.opening.messaging;

import com.example.bpm.brokerage.account.opening.constants.OpeningTopics;
import com.example.bpm.brokerage.account.opening.constants.OpeningVariables;
import com.example.bpm.brokerage.account.opening.dto.message.OpeningConfirmationMessage;
import com.example.bpm.brokerage.account.opening.dto.message.OpeningRejectionMessage;
import com.example.bpm.brokerage.account.util.CamundaRuntimeServiceFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OpeningAgreementConsumer {

    private final CamundaRuntimeServiceFacade runtimeServiceFacade;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = OpeningTopics.BROKERAGE_PROVIDER_CONFIRMATION)
    public void listenToOpeningConfirmationMessage(OpeningConfirmationMessage message, Acknowledgment ack) {
        log.info("Received OpeningConfirmationMessage for correlationId = {}", message.getCorrelationId());
        log.debug("Message = {}", message);

        runtimeServiceFacade.createMessageCorrelation(
                "openingAgreementResponseEvent",
                message.getCorrelationId(),
                OpeningVariables.ACCOUNT_REQUEST_CONFIRMED_BY_PROVIDER.get(),
                true);

        ack.acknowledge();
    }

    @KafkaListener(topics = OpeningTopics.BROKERAGE_PROVIDER_REJECTION)
    public void listenToOpeningRejectionMessage(OpeningRejectionMessage message, Acknowledgment ack) {
        log.info("Received OpeningRejectionMessage for correlationId = {}", message.getCorrelationId());
        log.debug("Message = {}", message);

        runtimeServiceFacade.createMessageCorrelation(
                "openingAgreementResponseEvent",
                message.getCorrelationId(),
                OpeningVariables.ACCOUNT_REQUEST_CONFIRMED_BY_PROVIDER.get(),
                false);

        ack.acknowledge();
    }
}
