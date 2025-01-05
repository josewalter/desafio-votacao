package com.dbserver.votacao.votacao.controller;

import com.dbserver.votacao.votacao.model.Sessao;
import com.dbserver.votacao.votacao.service.SessaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class SessaoController {
    @Autowired
    private SessaoService sessaoService;

    @ResponseBody
    @PostMapping("/sessoes")
    public ResponseEntity<Sessao> salvarSessao(@RequestBody @Valid  Sessao sessao) throws Exception {

        Sessao sessaoSalva = sessaoService.salvarSessao(sessao);
        return new ResponseEntity<>(sessaoSalva, HttpStatus.OK);



   }

    @GetMapping("/sessoes")
    public ResponseEntity<List<Sessao>> getAllSessao() {
        return ResponseEntity.status(HttpStatus.OK).body(sessaoService.getAll());
    }
}
