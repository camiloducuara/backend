package com.senasoft.participacionciudadana.infra.security.config;

import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**

 * Esta clase contiene la configuracion para encriptar la contraseña, se uso la implementacion de
 * BCryptPasswordEncoder

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see BCryptPasswordEncoder

 */
@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
