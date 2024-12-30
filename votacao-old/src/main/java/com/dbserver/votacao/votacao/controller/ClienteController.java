package com.dbserver.votacao.votacao.controller;

import com.dbserver.votacao.votacao.dto.ClienteRecordDto;
import com.dbserver.votacao.votacao.model.Cliente;
import com.dbserver.votacao.votacao.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes")
    @ResponseBody
    public ResponseEntity<Cliente> salveCliente(@RequestBody @Valid ClienteRecordDto clienteRecordDto) {
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteRecordDto, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(cliente));
    }
    /*
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllCliente() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAll());
    }

    @GetMapping("/clientes/{idCliente}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value = "idCliente")UUID idCliente) {
        Optional<Cliente> clienteOptional = clienteService.getById(idCliente);
        if(clienteOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
    }

    @PutMapping("/clientes/{idCliente}")
    public ResponseEntity<Object> atualizaCliente(@PathVariable(value = "idCliente") UUID idCliente, @RequestBody @Valid ClienteRecordDto clienteRecordDto) {
        Optional<Cliente> clienteOptional = clienteService.getById(idCliente);
        if(clienteOptional.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        var cliente = clienteOptional.get();
        BeanUtils.copyProperties(clienteRecordDto, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.salvarCliente(cliente));
    }

    @DeleteMapping("/clientes/{idCliente}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "idCliente") UUID idCliente) throws EntityInUseException {
        if (idCliente != null) {
            clienteService.deletarCliente(idCliente);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
    }
     */
}
