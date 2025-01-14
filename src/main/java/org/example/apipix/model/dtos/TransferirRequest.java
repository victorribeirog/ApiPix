package org.example.apipix.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferirRequest {
    private String chavePixOrigem;
    private String chavePixDestino;
    private BigDecimal valor;
    private String descricao;
}
