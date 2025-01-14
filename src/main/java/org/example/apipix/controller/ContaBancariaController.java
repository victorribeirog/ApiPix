package org.example.apipix.controller;

import org.example.apipix.model.dtos.ContaBancariaRequest;
import org.example.apipix.model.entities.ContaBancaria;
import org.example.apipix.service.interfaces.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contas")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    public ContaBancariaController(ContaBancariaService contaBancariaService) {
        this.contaBancariaService = contaBancariaService;
    }

    @PostMapping
    public ResponseEntity<ContaBancaria> cadastrar(@RequestBody ContaBancariaRequest contaBancariaRequest) {
        ContaBancaria conta = contaBancariaService.cadastrarConta(contaBancariaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }
}
