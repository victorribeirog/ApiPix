package org.example.apipix.controller;

import javax.validation.Valid;
import org.example.apipix.model.dtos.TransferirRequest;
import org.example.apipix.model.dtos.TransferirResponse;
import org.example.apipix.service.interfaces.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pix")
public class PixController {
    @Autowired
    private PixService pixService;

    @PostMapping("/transferir")
    public ResponseEntity<TransferirResponse> transferir(@RequestBody @Valid TransferirRequest transferirRequest) {
        return ResponseEntity.ok(pixService.transferir(transferirRequest));
    }
}
