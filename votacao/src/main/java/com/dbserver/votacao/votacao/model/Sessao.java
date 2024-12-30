package com.dbserver.votacao.votacao.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_sessao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sessao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sessao_id")
    private UUID idSessao;

    @Column(name = "voto", length = 4, nullable = false)
    private String voto;

    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
