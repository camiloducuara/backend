package com.senasoft.participacionciudadana.service.login;

import com.senasoft.participacionciudadana.infra.security.jwt.JwtTokenProvider;
import com.senasoft.participacionciudadana.repository.ciudadano.CuentaRepository;
import com.senasoft.participacionciudadana.service.exception.NotFoundException;
import com.senasoft.participacionciudadana.service.login.request.LoginRequest;
import com.senasoft.participacionciudadana.service.login.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CuentaRepository cuentaRepository;


    @Override
    public JwtResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);

        String role = cuentaRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new NotFoundException("user not found")).getRole();

        return new JwtResponse(jwt, role);

    }
}
