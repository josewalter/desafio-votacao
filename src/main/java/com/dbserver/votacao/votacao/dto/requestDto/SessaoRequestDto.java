package com.dbserver.votacao.votacao.dto.requestDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessaoRequestDto {

    private String voto;

    private String cliente;

}
