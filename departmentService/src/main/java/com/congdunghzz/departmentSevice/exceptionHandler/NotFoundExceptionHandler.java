package com.congdunghzz.departmentSevice.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handle (NotFoundException e){
        return new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }
}
