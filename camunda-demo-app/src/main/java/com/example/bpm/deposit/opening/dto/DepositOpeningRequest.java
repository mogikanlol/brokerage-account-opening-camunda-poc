package com.example.bpm.deposit.opening.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@Accessors(chain = true)
public class DepositOpeningRequest {

    @NotEmpty
    private String depositId;

    @NotEmpty
    private String correlationId;
}
