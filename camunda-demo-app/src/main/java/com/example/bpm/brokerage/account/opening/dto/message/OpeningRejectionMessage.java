package com.example.bpm.brokerage.account.opening.dto.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OpeningRejectionMessage {

    private String correlationId;

}
