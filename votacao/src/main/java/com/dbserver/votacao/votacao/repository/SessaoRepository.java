package com.dbserver.votacao.votacao.repository;

import com.dbserver.votacao.votacao.dto.recordDto.SessaoRecordDto;
import com.dbserver.votacao.votacao.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, UUID> {

}
