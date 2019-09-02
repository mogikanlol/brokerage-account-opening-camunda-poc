package com.example.bpm.deposit.opening.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class DepositOpeningRequest implements Serializable {

    @NotEmpty
    private String depositId;

    @NotEmpty
    private String correlationId;
}
