package com.dnd.exwise.expense.exception;


import com.dnd.exwise.expense.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExpenseGlobalExceptionHandler {

    @ExceptionHandler(ExpenseException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse expenseException(ExpenseException ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse globalException(Exception ex) {
        return new ApiResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }


}