package com.example.bpm.deposit.opening.messaging;

import com.example.bpm.deposit.opening.dto.message.DepositRequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@RequiredArgsConstructor
@Component
public class DepositAgreementProducer {

    private final OpeningStream stream;

    public void sendDepositRequest(DepositRequestMessage requestMessage) {
        Message<DepositRequestMessage> message = MessageBuilder
                .withPayload(requestMessage)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        stream.depositRequest().send(message);
    }

}
