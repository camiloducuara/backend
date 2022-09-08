package com.senasoft.participacionciudadana.infra.controller;

import com.senasoft.participacionciudadana.service.ciudadano.CiudadanoService;
import com.senasoft.participacionciudadana.service.ciudadano.request.CiudadanoRequest;
import com.senasoft.participacionciudadana.service.ciudadano.response.CiudadanoResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ciudadano")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "bearer")
public class CiudadanoController {

    private CiudadanoService ciudadanoService;

    public CiudadanoController(CiudadanoService ciudadanoService) {
        this.ciudadanoService = ciudadanoService;
    }

    @GetMapping()
    ResponseEntity<List<CiudadanoResponse>> getAll(){
        return ResponseEntity.ok(ciudadanoService.obtenerTodos());
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody CiudadanoRequest ciudadanoRequest){
        ciudadanoService.crear(ciudadanoRequest);
    }

    @GetMapping("/numeroDoc/{numeroDeDocumento}")
    ResponseEntity<CiudadanoResponse> getByNumeroDeDocumento(@PathVariable String numeroDeDocumento){
        return ResponseEntity.ok(ciudadanoService.obtenerPorNumeroDeDocumento(numeroDeDocumento));
    }

    @GetMapping("/etnia/{etnia}")
    ResponseEntity<List<CiudadanoResponse>> getByEtnia(@PathVariable String etnia){
        return ResponseEntity.ok(ciudadanoService.obtenerPorEtnia(etnia));
    }

}
