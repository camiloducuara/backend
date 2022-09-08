package com.senasoft.participacionciudadana.infra.security.jwt;

import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**

 * Esta clase se encarga de mandar el error 401 cuando la autenticacion no se halla podido realizar
 * correctamente

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see AuthenticationEntryPoint

 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
