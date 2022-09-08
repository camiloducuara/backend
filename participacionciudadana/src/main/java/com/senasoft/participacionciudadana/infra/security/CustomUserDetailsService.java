package com.senasoft.participacionciudadana.infra.security;

import com.senasoft.participacionciudadana.entity.ciudadano.Ciudadano;
import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import com.senasoft.participacionciudadana.repository.ciudadano.CiudadanoRepository;
import com.senasoft.participacionciudadana.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**

 * Esta clase se encanrga de cargar el usuario para posteriormente devolverlo en la implementacion
 * de User con sus Authorities dada por SpringSecurity

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see User

 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CiudadanoRepository ciudadanoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Ciudadano> ciudadanos = ciudadanoRepository.findAll();

        List<Ciudadano> ciudadanoPorNombreDeUsuario = ciudadanos.stream().filter(
                ciudadano -> username.equals(ciudadano.getIdentificacion().getCuenta().getUsername())
        ).collect(Collectors.toList());

        if (ciudadanoPorNombreDeUsuario.isEmpty()){
            throw new NotFoundException("Ciudadano no encontrado");
        }

        Ciudadano ciudadano = ciudadanoPorNombreDeUsuario.get(0);

        return new User(ciudadano.getIdentificacion().getCuenta().getUsername(),
                ciudadano.getIdentificacion().getCuenta().getPassword(),
                getAuthority(ciudadano.getIdentificacion().getCuenta().getRole()));

    }

    private Collection<? extends GrantedAuthority> getAuthority(String role){
        return Set.of(new SimpleGrantedAuthority(role));
    }
}
