package com.dbserver.votacao.votacao.controller;

import com.dbserver.votacao.votacao.model.Sessao;
import com.dbserver.votacao.votacao.service.SessaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SessaoController {
    @Autowired
    private SessaoService sessaoService;

    @ResponseBody
    @PostMapping("/sessoes")
    public ResponseEntity<Sessao> salvarSessao(@RequestBody @Valid  Sessao sessao) throws Exception {
        /*
        if (cliente == null) {
            throw new Exception("Cliente não pode ser NULL");
        }

        if (cliente.getIdCliente() == null && sessaoService.salvarSessao(cliente.getCpf()) != null){
           throw new Exception("status: UNABLE_TO_VOTE" + cliente.getCpf());
        }

        if (!ValidacaoCpf.isCPF(cliente.getCpf())) {
            throw new Exception("CPF : " + cliente.getCpf() + "status: UNABLE_TO_VOTE");
            return new  ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);
        }else {

         */
            sessao = sessaoService.salvarSessao(sessao);
            return new  ResponseEntity<Sessao>(sessao, HttpStatus.OK);

   }

    @GetMapping("/sessoes")
    public ResponseEntity<List<Sessao>> getAllSessao() {
        return ResponseEntity.status(HttpStatus.OK).body(sessaoService.getAll());
    }
}
