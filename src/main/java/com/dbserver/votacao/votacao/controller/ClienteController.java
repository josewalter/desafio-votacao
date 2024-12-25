package com.dbserver.votacao.votacao.controller;

import com.dbserver.votacao.votacao.model.Cliente;
import com.dbserver.votacao.votacao.repository.ClienteRepository;
import com.dbserver.votacao.votacao.service.ClienteService;
import com.dbserver.votacao.votacao.util.ValidacaoCpf;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @ResponseBody
    @PostMapping("/clientes")
    public  ResponseEntity<Cliente> salvaCliente(@RequestBody @Valid Cliente cliente) throws Exception {

        if (cliente == null) {
            throw new Exception("Cliente não pode ser NULL");
        }
/*
        if (cliente.getIdCliente() == null && clienteRepository.existeCadastroCpf(cliente.getCpf()) != null) {
            throw  new Exception("Já existe um CPF cadastrado com esse número! " + cliente.getCpf());
        }

       if (!ValidacaoCpf.isCPF(cliente.getCpf())) {
           throw new Exception("CPF: " + cliente.getCpf() + "status: UNABLE_TO_VOTE" );
       }else {
           throw new Exception("CPF: " + cliente.getCpf() + "status: ABLE_TO_VOTE" );
       }
*/
        cliente = clienteService.salvarCliente(cliente);

        return new  ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllCliente() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAll());
    }
}
