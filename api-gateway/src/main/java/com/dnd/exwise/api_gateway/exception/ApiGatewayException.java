package com.dnd.exwise.api_gateway.exception;

public class ApiGatewayException extends RuntimeException{

    public ApiGatewayException(String mess) {
        super(mess);
    }
}
