package com.dbserver.votacao.votacao.dto.recordDto;

import com.dbserver.votacao.votacao.model.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SessaoRecordDto(@NotBlank String voto, @NotNull Cliente cliente){

}
