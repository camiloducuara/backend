package com.senasoft.participacionciudadana.service.exception.advice;

import com.senasoft.participacionciudadana.entity.adminsondeo.PreguntaAdmin;
import com.senasoft.participacionciudadana.service.exception.BadRequestException;
import com.senasoft.participacionciudadana.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**

 * Se usa para dar el estado de bad request a las peticiones que no cumplan con la validacion
 * de la peticion

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see BadRequestException

 */
@ControllerAdvice
public class BadRequestExceptionAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public String badRequestExceptionHandler(BadRequestException notFoundException){
        return notFoundException.getMessage();
    }
}
