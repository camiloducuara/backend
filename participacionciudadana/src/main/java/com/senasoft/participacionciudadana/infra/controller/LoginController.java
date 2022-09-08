package com.senasoft.participacionciudadana.infra.controller;

import com.senasoft.participacionciudadana.service.login.LoginService;
import com.senasoft.participacionciudadana.service.login.request.LoginRequest;
import com.senasoft.participacionciudadana.service.login.response.JwtResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/login")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "bearer")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(loginService.login(loginRequest));
    }

}
