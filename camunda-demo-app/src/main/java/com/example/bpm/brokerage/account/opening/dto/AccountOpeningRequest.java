package com.example.bpm.brokerage.account.opening.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class AccountOpeningRequest implements Serializable {

    @NotEmpty
    private String tariffId;

    @NotEmpty
    private String correlationId;
}
