package org.example.apipix.service.interfaces;

import org.example.apipix.model.dtos.TransferirRequest;
import org.example.apipix.model.dtos.TransferirResponse;

public interface PixService {
    TransferirResponse transferir(TransferirRequest transferirRequest);
}
