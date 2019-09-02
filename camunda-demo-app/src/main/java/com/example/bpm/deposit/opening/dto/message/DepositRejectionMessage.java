package com.example.bpm.deposit.opening.dto.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DepositRejectionMessage {

    private String depositId;

}
