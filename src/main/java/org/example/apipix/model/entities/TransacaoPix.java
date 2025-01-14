package org.example.apipix.model.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.apipix.model.enums.TipoQRCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoPix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chavePixOrigem;
    private String chavePixDestino;
    private BigDecimal valor;
    private LocalDateTime dataTransacao;

    @Enumerated(EnumType.STRING)
    private TipoQRCode tipoQRCode;
}