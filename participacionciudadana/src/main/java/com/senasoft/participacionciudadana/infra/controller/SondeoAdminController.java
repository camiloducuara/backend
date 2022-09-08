package com.senasoft.participacionciudadana.infra.controller;

import com.senasoft.participacionciudadana.service.sondeoadmin.SondeoAdminService;
import com.senasoft.participacionciudadana.service.sondeoadmin.request.SondeoAdminRequest;
import com.senasoft.participacionciudadana.service.sondeoadmin.response.SondeoAdminResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sondeo-admin")
@CrossOrigin(origins = "*")
public class SondeoAdminController {

    private SondeoAdminService sondeoAdminService;

    public SondeoAdminController(SondeoAdminService sondeoAdminService) {
        this.sondeoAdminService = sondeoAdminService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SondeoAdminResponse>> getAll(){
        return ResponseEntity.ok(sondeoAdminService.getAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<SondeoAdminResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(sondeoAdminService.getById(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SondeoAdminRequest sondeoAdmin){
        sondeoAdminService.create(sondeoAdmin);
    }


}
