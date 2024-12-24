package com.dbserver.votacao.votacao.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_clientes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id")
    private UUID idCliente;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "nome_cliente", length = 40, nullable = false)
    private String nomeCliente;
}
