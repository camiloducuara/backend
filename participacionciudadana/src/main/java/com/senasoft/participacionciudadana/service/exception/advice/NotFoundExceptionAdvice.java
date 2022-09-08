package com.senasoft.participacionciudadana.service.exception.advice;

import com.senasoft.participacionciudadana.entity.adminsondeo.PreguntaAdmin;
import com.senasoft.participacionciudadana.service.exception.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**

 * Retorna el estado de no encontrado para las consultas que no tengan respuesta

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see NotFoundException

 */

@ControllerAdvice
public class NotFoundExceptionAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String notFoundExceptionHandler(NotFoundException notFoundException){
        return notFoundException.getMessage();
    }
}
