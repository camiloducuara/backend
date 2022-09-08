package com.senasoft.participacionciudadana.infra.controller;

import com.senasoft.participacionciudadana.service.sondeouser.SondeoUserService;
import com.senasoft.participacionciudadana.service.sondeouser.request.SondeoCiudadanoRequest;
import com.senasoft.participacionciudadana.service.sondeouser.response.SondeoCiudadanoResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sondeo-ciudadano")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "bearer")
public class SondeoCiudadanoController {

    @Autowired
    private SondeoUserService sondeoUserService;

    @GetMapping
    public ResponseEntity<List<SondeoCiudadanoResponse>> obtenerTodosLosSondeos(){
        return ResponseEntity.ok(sondeoUserService.ObtenerTodosLosSondeos());
    }

    @PostMapping("/responder")
    public void responder(@RequestBody SondeoCiudadanoRequest sondeoCiudadanoRequest){
        sondeoUserService.responderSondeo(sondeoCiudadanoRequest);
    }

    @GetMapping("/nombreUsuario/{username}")
    public ResponseEntity<List<SondeoCiudadanoResponse>> ObtenerSondeoPorNombreDeUsuario(
            @PathVariable String username){

        return ResponseEntity.ok(sondeoUserService.obtenerSondeosPorNombreDeUsuario(username));

    }

    @GetMapping("/etnia/{etnia}")
    public ResponseEntity<List<SondeoCiudadanoResponse>> ObtenerSondeoPorEtnia(
            @PathVariable String etnia
    ){
        return ResponseEntity.ok(sondeoUserService.obtenerSondeosPorEtnia(etnia));
    }

}
