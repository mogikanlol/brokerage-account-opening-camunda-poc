package com.example.bpm.deposit.configuration;

import com.example.bpm.deposit.opening.messaging.OpeningStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(OpeningStream.class)
public class StreamConfiguration {
}
