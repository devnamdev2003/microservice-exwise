package com.dnd.exwise.api_gateway.exception;

import com.dnd.exwise.api_gateway.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiGatewayGlobalExceptionHandler {

    @ExceptionHandler(ApiGatewayException.class)
    public ApiResponse apiGatewayException(ApiGatewayException ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse globalException(Exception ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
