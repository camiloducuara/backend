package com.senasoft.participacionciudadana.infra;

import com.senasoft.participacionciudadana.service.ciudadano.CiudadanoService;
import com.senasoft.participacionciudadana.service.ciudadano.request.CiudadanoRequest;
import com.senasoft.participacionciudadana.service.ciudadano.response.CiudadanoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ciudadano")
public class CiudadanoController {

    private CiudadanoService ciudadanoService;

    public CiudadanoController(CiudadanoService ciudadanoService) {
        this.ciudadanoService = ciudadanoService;
    }

    @GetMapping()
    ResponseEntity<List<CiudadanoResponse>> getAll(){
        return ResponseEntity.ok(ciudadanoService.obtenerTodos());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody CiudadanoRequest ciudadanoRequest){
        ciudadanoService.crear(ciudadanoRequest);
    }

    @GetMapping("numeroDoc/{numeroDeDocumento}")
    ResponseEntity<CiudadanoResponse> getByNumeroDeDocumento(@PathVariable String numeroDeDocumento){
        return ResponseEntity.ok(ciudadanoService.obtenerPorNumeroDeDocumento(numeroDeDocumento));
    }

    @GetMapping("etnia/{etnia}")
    ResponseEntity<CiudadanoResponse> getByEtnia(@PathVariable String etnia){
        return ResponseEntity.ok(ciudadanoService.obtenerPorEtnia(etnia));
    }

}
