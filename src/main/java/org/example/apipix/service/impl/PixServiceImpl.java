package org.example.apipix.service.impl;

import org.example.apipix.model.dtos.TransferirRequest;
import org.example.apipix.model.dtos.TransferirResponse;
import org.example.apipix.model.entities.ContaBancaria;
import org.example.apipix.model.entities.TransacaoPix;
import org.example.apipix.repository.ContaBancariaRepository;
import org.example.apipix.repository.TransacaoPixRepository;
import org.example.apipix.service.interfaces.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PixServiceImpl implements PixService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    @Autowired
    private TransacaoPixRepository transacaoPixRepository;

    @Override
    public TransferirResponse transferir(TransferirRequest transferirRequest) {
        ContaBancaria origem = contaBancariaRepository.findByChavePix(transferirRequest.getChavePixOrigem())
                .orElseThrow(() -> new IllegalArgumentException("Chave Pix origem inválida"));
        ContaBancaria destino = contaBancariaRepository.findByChavePix(transferirRequest.getChavePixDestino())
                .orElseThrow(() -> new IllegalArgumentException("Chave Pix destino inváldia"));

        if (origem.getSaldoInicial().compareTo(transferirRequest.getValor()) < 0){
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        origem.setSaldoInicial(origem.getSaldoInicial().subtract(transferirRequest.getValor()));
        destino.setSaldoInicial(destino.getSaldoInicial().add(transferirRequest.getValor()));

        contaBancariaRepository.save(origem);
        contaBancariaRepository.save(destino);

        TransacaoPix transacaoPix = new TransacaoPix();
        transacaoPix.setChavePixOrigem(transferirRequest.getChavePixOrigem());
        transacaoPix.setChavePixDestino(transferirRequest.getChavePixDestino());
        transacaoPix.setValor(transferirRequest.getValor());
        transacaoPix.setDataTransacao(LocalDateTime.now());
        transacaoPixRepository.save(transacaoPix);

        TransferirResponse transferirResponse = new TransferirResponse();
        transferirResponse.setStatus("Sucesso");
        transferirResponse.setMensagem("Transferencia realizada com Sucesso");
        transferirResponse.setDataTransacao(LocalDateTime.now());
        return transferirResponse;
    }
}
