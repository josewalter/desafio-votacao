package com.dbserver.votacao.votacao.service;

import com.dbserver.votacao.votacao.model.Sessao;
import com.dbserver.votacao.votacao.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    public Sessao salvarSessao(Sessao sessao) {

        sessaoRepository.save(sessao);
        System.out.println("O sessao" + sessao + ", foi salva com sucesso!!");
        return sessao;
    }

    public List<Sessao> getAll(){

        return sessaoRepository.findAll();
    }
}
