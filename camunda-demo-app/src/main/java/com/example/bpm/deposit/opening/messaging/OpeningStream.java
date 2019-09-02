package com.example.bpm.deposit.opening.messaging;

import com.example.bpm.deposit.opening.constants.OpeningTopics;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OpeningStream {

    @Input(OpeningTopics.DEPOSIT_PROVIDER_CONFIRMATION)
    SubscribableChannel depositConfirmation();

    @Input(OpeningTopics.DEPOSIT_PROVIDER_REJECTION)
    SubscribableChannel depositRejection();

    @Output(OpeningTopics.DEPOSIT_PROVIDER_REQUEST)
    MessageChannel depositRequest();

}
