package com.dbserver.votacao.votacao.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequestDto {

    private String nomeCliente;

    private String cpf;

}
