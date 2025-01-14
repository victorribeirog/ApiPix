package org.example.apipix.service.interfaces;

import org.example.apipix.model.dtos.ContaBancariaRequest;
import org.example.apipix.model.entities.ContaBancaria;

public interface ContaBancariaService {
    ContaBancaria cadastrarConta(ContaBancariaRequest request);
}
