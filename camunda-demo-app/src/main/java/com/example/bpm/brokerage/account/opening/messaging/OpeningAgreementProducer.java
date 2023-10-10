package com.example.bpm.brokerage.account.opening.messaging;

import com.example.bpm.brokerage.account.opening.dto.message.OpeningRequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@RequiredArgsConstructor
@Component
public class OpeningAgreementProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendOpeningRequest(OpeningRequestMessage requestMessage){
        Message<OpeningRequestMessage> message = MessageBuilder
                .withPayload(requestMessage)
                .setHeader(KafkaHeaders.TOPIC, "stub-topic")
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();

        kafkaTemplate.send(message);
    }

}
