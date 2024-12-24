package com.dbserver.votacao.votacao.dto.recordDto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record ClienteRecordDto (@NotBlank String nomeCliente, @NotBlank String cpf){
}