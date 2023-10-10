package com.example.bpm.brokerage.account.opening.constants;

import com.example.bpm.brokerage.account.util.ProcessVariable;

public class OpeningVariables {

    private OpeningVariables() {}

    public static final ProcessVariable<String> CORRELATION_ID = () -> "correlationId";
    public static final ProcessVariable<String> PROVIDER_TARIFF_ID = () -> "tariffId";
    public static final ProcessVariable<String> ACCOUNT_REQUEST_CONFIRMED_BY_PROVIDER = () -> "openingRequestConfirmedByProvider";
    public static final ProcessVariable<String> INITIAL_MESSAGE = () -> "initialMessage";
}
