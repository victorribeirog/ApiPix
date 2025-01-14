package org.example.apipix.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferirResponse {
    private String status;
    private String mensagem;
    private LocalDateTime dataTransacao;
}
