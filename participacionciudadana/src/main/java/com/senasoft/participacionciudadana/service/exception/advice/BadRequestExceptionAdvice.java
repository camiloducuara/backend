package com.senasoft.participacionciudadana.service.exception.advice;

import com.senasoft.participacionciudadana.service.exception.BadRequestException;
import com.senasoft.participacionciudadana.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BadRequestExceptionAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public String badRequestExceptionHandler(BadRequestException notFoundException){
        return notFoundException.getMessage();
    }
}
