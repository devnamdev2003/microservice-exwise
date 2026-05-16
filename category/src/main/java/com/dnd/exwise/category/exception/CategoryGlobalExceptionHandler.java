package com.dnd.exwise.category.exception;

import com.dnd.exwise.category.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CategoryGlobalExceptionHandler {

    @ExceptionHandler(CategoryException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse categoryException(CategoryException ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse globalException(Exception ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}