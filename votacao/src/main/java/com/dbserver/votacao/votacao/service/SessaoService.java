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

        /*
        for (int i = 0; i < sessao.getCliente().getCpf().equalsIgnoreCase(); i++) {
            sessao.getCliente().getCpf();
            sessao.getCliente().getNomeCliente();
        }


        ValidacaoCpf isCpf = new ValidacaoCpf(610.658.880-58);
        if (ValidacaoCpf.isCpf(clienteRepository.getCpf())){
            System.out.println("status: ABLE_TO_VOTE");
        }else {
            System.out.println("status: UNABLE_TO_VOTE");
        }

        sessaoRepository.save(sessao);
        System.out.println("A sessão,  " + sessao + ", foi salva com sucesso!!");
        return sessao;

         */
    }

    public List<Sessao> getAll(){

        return sessaoRepository.findAll();
    }
}
