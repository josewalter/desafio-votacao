package com.dbserver.votacao.votacao.repository;

import com.dbserver.votacao.votacao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
   /*
    @Query(value = "SELECT c FROM db_votacao.tbl_clientes c WHERE c.cpf = ?1")
    public Cliente existeCadastroCpf(String cpf);

    */
}
