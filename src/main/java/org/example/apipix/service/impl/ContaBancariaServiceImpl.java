package org.example.apipix.service.impl;

import org.example.apipix.model.dtos.ContaBancariaRequest;
import org.example.apipix.model.entities.ContaBancaria;
import org.example.apipix.repository.ContaBancariaRepository;
import org.example.apipix.service.interfaces.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaServiceImpl implements ContaBancariaService {

    @Autowired
    private  ContaBancariaRepository contaBancariaRepository;

    @Override
    public ContaBancaria cadastrarConta(ContaBancariaRequest request){
        if (contaBancariaRepository.findByChavePix(request.getChavePix()).isPresent()){
            throw new IllegalArgumentException("Chave Pix já cadastrada");
        }

        ContaBancaria conta = new ContaBancaria();
        conta.setChavePix(request.getChavePix());
        conta.setTitular(request.getTitular());
        conta.setTipoConta(request.getTipoConta());
        conta.setSaldoInicial(request.getSaldoInicial());

        return contaBancariaRepository.save(conta);
    }
}
