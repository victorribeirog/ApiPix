package org.example.apipix.model.dtos;

import lombok.*;
import org.example.apipix.model.enums.TipoConta;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancariaRequest {
    private String titular;
    private String chavePix;
    private TipoConta tipoConta;
    private BigDecimal saldoInicial;
}
