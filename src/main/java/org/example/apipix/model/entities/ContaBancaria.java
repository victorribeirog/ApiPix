package org.example.apipix.model.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.apipix.model.enums.TipoConta;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private TipoConta tipoConta;
    private BigDecimal saldoInicial;
    private String titular;
    private String chavePix;
}
