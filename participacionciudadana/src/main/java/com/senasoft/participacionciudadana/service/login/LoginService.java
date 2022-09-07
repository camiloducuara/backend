package com.senasoft.participacionciudadana.service.login;

import com.senasoft.participacionciudadana.service.login.request.LoginRequest;
import com.senasoft.participacionciudadana.service.login.response.JwtResponse;

public interface LoginService {
    JwtResponse login(LoginRequest loginRequest);
}
