package com.senasoft.participacionciudadana.service.login;

import com.senasoft.participacionciudadana.service.login.request.LoginRequest;
import com.senasoft.participacionciudadana.service.login.response.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{


    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        return null;
    }
}
