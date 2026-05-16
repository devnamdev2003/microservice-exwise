package com.dnd.exwise.user.exception;


import com.dnd.exwise.user.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ApiResponse userException(UserException ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse globalException(Exception ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
