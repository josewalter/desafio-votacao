package com.dbserver.votacao.votacao.controller;

import com.dbserver.votacao.votacao.model.Cliente;
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

    @ResponseBody
    @PostMapping("/clientes")
    public ResponseEntity<String> salvaCliente(@RequestBody @Valid Cliente cliente) throws Exception {

       if (ValidacaoCpf.isCPF(cliente.getCpf())) {
           cliente = clienteService.salvarCliente(cliente);
           //throw new Exception("CPF: " + cliente.getCpf() + "status: ABLE_TO_VOTE" );
           return ResponseEntity.status(HttpStatus.OK).body("CPF: " + cliente.getCpf() + " status: ABLE_TO_VOTE" );
       }else {
           // throw new Exception("CPF: " + cliente.getCpf() + "status: ABLE_TO_VOTE" );
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" status: UNABLE_TO_VOTE ");
       }

        //return ResponseEntity.status(HttpStatus.OK).body(clienteService.salvarCliente(cliente));
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllCliente() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAll());
    }
}
